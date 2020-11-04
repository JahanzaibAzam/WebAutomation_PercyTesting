package general;


import objects.CommonLocators;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

import static general.WebDriverFactory.action;
import static org.apache.commons.lang3.StringUtils.substringAfter;


public class GenericFunctions {

    public static By byButton = By.tagName("button");
    public static By byInput = By.tagName("input");
    //    int rowCount = WebDriverFactory.getDriver().findElements(commonLocators.byTr).size() - 1;
    int countB ;
    int totalCountB ;
    int countA;
    int totalCountA ;

    public static String generateRandomNum(int length)
    {
        String RawRandomNumber = RandomStringUtils.randomNumeric(length);
        return RawRandomNumber;
    }

    public static List<Integer> generateRandomNumSystem(int length, int sysCount)
    {
        List<Integer> RawRandomNumber = new ArrayList<>();
        for (int i=0 ; i<sysCount ; i++) {
            RawRandomNumber.add(Integer.valueOf(RandomStringUtils.randomNumeric(length)));
        }
        return RawRandomNumber;
    }

    public static String generateAlphaNumeric(String s, int length)
    {
        String RawRandomNumber = RandomStringUtils.randomNumeric(length);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s);
        stringBuilder.append(RawRandomNumber);
        return stringBuilder.toString();
    }

    public static String RandomPhoneNumber(String RawRandomNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("+92300");
        stringBuilder.append(RawRandomNumber);
        return stringBuilder.toString();
    }

    public static String generateRandomString(int length) {
        String name = RandomStringUtils.randomAlphabetic(length);
        String first_letter = name.substring(0, 1).toUpperCase();
        String other_letters = name.substring(1).toLowerCase();
        String finalname = first_letter + other_letters;
        return finalname;
    }

    public static String generateEmail(String finalname)
    {
        return finalname + "@vd.com";
    }

    public static void clearFieldWithJS(By locator, String input) {
        JavascriptExecutor js = (JavascriptExecutor)WebDriverFactory.getDriver();
        String element = substringAfter(locator.toString(), ": ");

        js.executeScript("document.getElementById('" + element + "').value = '" + input + "'");
    }

    public static void mouseHover(By by){
//        action = new Actions(WebDriverFactory.getDriver());
        action.moveToElement(WebDriverFactory.getDriver().findElement(by))
                .perform();
    }

    public static int stringToInt(String number) {
        int result = Integer.parseInt(number);
        return result;
    }

    public void clickElementByText(String text) throws InterruptedException {
        WebDriverFactory.getDriver().findElement(By.xpath("//*[contains(text(), '" + text + "')]")).click();
        Thread.sleep(1000);
    }

    public int getColumnsName(String columnName)
    {
        int i = 0;
        List<WebElement> elements11 = WebDriverFactory.getDriver().findElement(CommonLocators.byThead).
                findElements(CommonLocators.byTr).get(1).findElements(CommonLocators.byTh);

        for (WebElement element: elements11) {
            if (element.getText().trim().equals(columnName))
            {
                break;
            }
            i++;
        }
        return i;
    }

    public List<WebElement> getRowsOfTable() {
        return WebDriverFactory.getDriver().findElement(CommonLocators.byTable).findElements(CommonLocators.byTr);

    }

    public void clickOnColumnOfTable(String itemName) {
        List<WebElement> Rows = getRowsOfTable();
        for (int i = 0; i <= Rows.size(); i++) {
            List<WebElement> Columns = WebDriverFactory.getDriver().findElements(CommonLocators.byTd);
            for (WebElement Column : Columns)
                if (Column.getText().trim().equals(itemName)) {
                    Actions actions = new Actions(WebDriverFactory.getDriver());
                    actions.click(Column).build().perform();
                    break;
                }
        }
        WebDriverWaits.waitUntilLoaderDisapears();
    }

    public void scrollUp() {
        WebElement element = WebDriverFactory.getDriver().findElement(By.className("locator"));
        ((JavascriptExecutor) WebDriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView(true)", element);

    }


}