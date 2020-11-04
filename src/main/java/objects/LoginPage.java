package objects;

import general.WebDriverFactory;
import general.WebDriverWaits;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static config.ConfigProperties.Url;
import static config.ConfigProperties.appConfig;
import static utils.LogHelper.logStep;

public class LoginPage
{
    public LoginPage() {}

    //Login Page Functions

    public static By byLoginWelcome = By.id("logout-link");

    public static By byEmail = By.name("useremail");
    public static By byPassword = By.name("password");
    public static By byLogin = By.cssSelector("span[class*='jss']");

    public static By byPopUp = By.className("__floater__body");
    public static By bySkip = By.cssSelector("button[title='Skip']");

    public static By byHeaderMenu = By.cssSelector(".list-header-settings .border-l");
    public static By byProfile = By.cssSelector(".user-settings li:nth-child(1)");
    public static By byFeedback = By.cssSelector(".user-settings li:nth-child(2)");
    public static By byRole = By.cssSelector(".user-settings li:nth-child(3)");
    public static By byLogout = By.cssSelector(".user-settings li:nth-child(4)");

    public static By byHeading = By.id("heading");
    public static By byHelpPopUpCross = By.className("help-cross-btn");

    public static By byNewUser = By.partialLinkText("New User");
    public static By byForgetPassword = By.partialLinkText("Forgot your password");

    public static By byFirstName = By.name("firstname");
    public static By byLastName = By.name("lastname");
    public static By byCompany = By.name("account_name");
    public static By byTermsAndConditionCheck = By.cssSelector("input[type='checkbox']");
    public static By bySubmit = By.className("undefined");

    public static By byH4 = By.tagName("h4");
    public static By byButton = By.tagName("button");
    public static By bySpan = By.tagName("span");
    public static By byGotItButon = By.className("cc-btn");

    public void enterUserDetails(String userMail, String pwd) {
        logStep("User enters email and password");

        WebDriverFactory.getDriver().findElement(byEmail).sendKeys(userMail);
        WebDriverFactory.getDriver().findElement(byPassword).sendKeys(pwd);
    }

    public void clickGotIt()
    {
        if (appConfig.getDevice().equals("Windows")) {
            WebDriverFactory.getDriver().findElement(byGotItButon).click();
            WebDriverWaits.sleep1000();
        } else {
        }
    }

    public void clickLogin(){
        logStep("User clicks on Login button");

        WebElement elements = WebDriverFactory.getDriver().findElement(byLogin);

        elements.click();
    }

    public void clickLoginOnWelcomeScreen(){
        logStep("User clicks on Login in Welcome Screen");

        if (Url.contains("localhost"))
            WebDriverFactory.getDriver().findElement(byLoginWelcome).click();
    }
    public void verifyWelcomeScreen(){
        logStep("Verify Welcome Screen");
        WebDriverFactory.getDriver().findElement(byLoginWelcome).click();
    }

    public void selectHelpPopUpCross(){
        logStep("User clicks on cross on help popup");
        WebDriverFactory.getDriver().findElement(byHelpPopUpCross).click();
    }

    public void selectSkipButton(){
        logStep("User clicks on Skip button");
        if (WebDriverFactory.getDriver().getPageSource().contains("title=\"Skip\"")){
            Assert.assertTrue(WebDriverFactory.getDriver().findElement(bySkip).isDisplayed());
            WebDriverFactory.getDriver().findElement(bySkip).click();
        }
    }

    public void selectNewUser(){
        WebDriverFactory.getDriver().findElement(byNewUser).click();
    }

    public void selectForgetPassword(){
        WebDriverFactory.getDriver().findElement(byForgetPassword).click();
        Assert.assertTrue(WebDriverFactory.getDriver().findElement(byH4).getText().equals("Reset Password"));
    }

    public void enterEmail(String email){
        WebDriverFactory.getDriver().findElement(byEmail).sendKeys(email);
    }

    public void fillSignUp(String firstname, String lastname, String email, String password, String company){
        WebDriverFactory.getDriver().findElement(byFirstName).sendKeys(firstname);
        WebDriverFactory.getDriver().findElement(byLastName).sendKeys(lastname);
        WebDriverFactory.getDriver().findElement(byEmail).sendKeys(email);
        WebDriverFactory.getDriver().findElement(byPassword).sendKeys(password);
        WebDriverFactory.getDriver().findElement(byCompany).sendKeys(company);

        WebDriverFactory.getDriver().findElement(byTermsAndConditionCheck).click();
    }

    public void selectForgetPasswordSumbit(){
        WebDriverFactory.getDriver().findElements(byButton).get(1).findElements(bySpan).get(1).click();
    }

    public void selectBack(){
        WebDriverFactory.getDriver().findElements(byButton).get(0).findElements(bySpan).get(1).click();
    }

    public void selectSignUpSumbit(){
        WebDriverFactory.getDriver().findElement(bySubmit).click();
    }

}
