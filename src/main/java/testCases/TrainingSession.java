package testCases;

import general.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.Thread.sleep;

public class TrainingSession extends BaseTest {

    @Test(description = "124640")
    public static void AlertWindow()
    {
        WebDriverFactory.getDriver().get("https://www.seleniumeasy.com/test/bootstrap-modal-demo.html");
        WebDriverFactory.getDriver().manage().window().maximize();
        List<WebElement> launchModule = WebDriverFactory.getDriver().findElements(By.className("btn-primary"));
        launchModule.get(2).click();
    }
//    @Test(description = "124640")
//    public static void Slider() throws InterruptedException
//    {
//        WebDriverFactory.getDriver().get("https://www.seleniumeasy.com/test/drag-drop-range-sliders-demo.html");
//        WebDriverFactory.getDriver().manage().window().maximize();
//        sleep(2000);
//        WebElement slider = WebDriverFactory.getDriver().findElement(By.id("slider3")).findElement(By.name("range"));
//        Actions act = new Actions(WebDriverFactory.getDriver());
//        act.dragAndDropBy(slider,60,0).build().perform();
//        String text = WebDriverFactory.getDriver().findElement(By.id("rangeSuccess")).getText();
//        System.out.println("slider text is : " + text);
//        Assert.assertEquals(1,2);
//    }
    @Test(description = "124640")
    public static void JavaScriptAlert() throws InterruptedException
    {
        WebDriverFactory.getDriver().get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
        WebDriverFactory.getDriver().manage().window().maximize();
        List<WebElement> button = WebDriverFactory.getDriver().findElements(By.className("btn-default"));
        button.get(2).click();
        sleep(2000);
        WebDriverFactory.getDriver().switchTo().alert().sendKeys("Training Session 02");
        sleep(2000);
        WebDriverFactory.getDriver().switchTo().alert().accept();
        sleep(2000);
    }
    @Test(description = "124640")
    public static void InputForm() throws InterruptedException
    {
        WebDriverFactory.getDriver().get("https://www.seleniumeasy.com/test/input-form-demo.html");
        WebDriverFactory.getDriver().manage().window().maximize();
        WebDriverFactory.getDriver().findElement(By.name("first_name")).sendKeys("firstnme");
        WebDriverFactory.getDriver().findElement(By.name("last_name")).sendKeys("lastname");
        WebDriverFactory.getDriver().findElement(By.name("email")).sendKeys("spider@gmail.com");
        WebDriverFactory.getDriver().findElement(By.name("phone")).sendKeys("(92)3336401111");
        WebDriverFactory.getDriver().findElement(By.name("address")).sendKeys("my home address");
        WebDriverFactory.getDriver().findElement(By.name("city")).sendKeys("My city");
        Select state = new Select(WebDriverFactory.getDriver().findElement(By.name("state")));
        state.selectByVisibleText("California");
        WebDriverFactory.getDriver().findElement(By.name("zip")).sendKeys("86400");
        WebDriverFactory.getDriver().findElement(By.name("website")).sendKeys("https://www.google.com");
        List<WebElement> radiobutton = WebDriverFactory.getDriver().findElements(By.cssSelector("input[type='radio']"));
        radiobutton.get(1).click();
        sleep(5000);
    }
}