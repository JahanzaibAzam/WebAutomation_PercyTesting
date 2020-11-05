package testCases;

//import com.assertthat.selenium_shutterbug.core.Capture;
//import com.assertthat.selenium_shutterbug.core.Shutterbug;
//import com.assertthat.selenium_shutterbug.utils.web.Coordinates;
import general.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.percy.selenium.Percy;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

import static config.ConfigProperties.Device;

public class Applitool extends BaseTest {
    static WebDriver driver;

    static String device = Device;

    public static final String AUTOMATE_USERNAME = "syedjahanzaibaza1";
    public static final String AUTOMATE_ACCESS_KEY = "AcqceVz1CYUk9skLUoJT";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";


    static String UbuntuChromDriverPath = device.equals("Ubuntu") ? "driver/chromedriver" : "driver/chromedriver";

    @Test
    public void basicTest() throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", UbuntuChromDriverPath);
//        driver = new ChromeDriver();

//        Shutterbug.shootPage(driver).withName("Application").save("//home//vend//Downloads//venturedive-web-automation-framework-216936e8104d//screenshots//AppRecordor");


//        Percy percy = new Percy(driver);
//        driver.get("https://www.google.com/");
//        driver.manage().window().maximize();
//        percy.snapshot("Home Page");
//        File image = new File("//home//vend//Downloads//venturedive-web-automation-framework-216936e8104d//screenshots//AppRecordor//Application.png");
//        BufferedImage expectedImage = ImageIO.read(image);
//        boolean status = Shutterbug.shootPage(driver).equals(expectedImage);
//        Assert.assertTrue("Images are not identical",status);

//        Thread.sleep(2000);
//        driver.quit();


        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", "iPhone");
        caps.setCapability("device", "iPhone 11");
        caps.setCapability("realMobile", "true");
        caps.setCapability("os_version", "14.0");
        caps.setCapability("name", "BStack-[Java] Sample Test"); // test name
        caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name
        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        driver.get("https://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("BrowserStack");
        element.submit();
        System.out.println(driver.getTitle());
        driver.quit();
    }
}