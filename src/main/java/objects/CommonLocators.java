package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static general.WebDriverFactory.action;
import static general.WebDriverFactory.robot;
import static utils.LogHelper.logStep;


public class CommonLocators {
    public CommonLocators(){}

    public static By byDiv = By.tagName("div");
    public static By byThead = By.tagName("thead");
    public static By byTable = By.tagName("tbody");
    public static By byTr = By.tagName("tr");
    public static By byTd = By.tagName("td");
    public static By byTh = By.tagName("th");
    public static By byFooter = By.tagName("tfoot");
    public static By byButton = By.tagName("button");
    public static By byChipletLibHeaderButtons = By.className("add-chiplet-btn");

    public static By byChipletLibraryButton = By.className("btn-primary");

    public static By byDropdwnButtons = By.className("btn-link");
    public static By bylogo = By.className("app-logo");


    //Common Functions

    public void clearField(WebElement element){
        int input = element.getAttribute("value").length();

        for(int i=0; i<input ;i++){
            element.sendKeys(Keys.BACK_SPACE);
        }
    }


    public void escape(){
        action.sendKeys(Keys.ESCAPE).perform();
    }

    public void delete(){
//        action = new Actions(WebDriverFactory.getDriver());
        action.sendKeys(Keys.DELETE).perform();
    }


    public void fileSelectionForMac(String path) throws AWTException, InterruptedException {
        logStep("User searches and selects file to import");

        String dir = System.getProperty("user.dir");
        StringSelection StringSelection = new StringSelection(dir + path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(StringSelection, null);

        //Open Goto window
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_G);
        robot.keyRelease(KeyEvent.VK_G);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_SHIFT);

        //Paste the clipboard value
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_V);

        //Press Enter key to close the Goto window and Upload window
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    //File upload by Robot Class
    public void uploadFileWithRobot (String filePath) throws AWTException {
        Robot robot = new Robot();

        String dir = System.getProperty("user.dir");
        dir = dir.substring(2, dir.length());
//        type(dir + envGlobals.chottaFilePath);
////        robot.keyPress(KeyEvent.VK_SHIFT);
//        robot.keyPress(KeyEvent.VK_UNDERSCORE);
////        robot.keyRelease(KeyEvent.VK_SHIFT);
//        robot.keyRelease(KeyEvent.VK_UNDERSCORE);
//        type(dir + envGlobals.chottaFilePath2);

        StringSelection stringSelection = new StringSelection(filePath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        robot.delay(2000);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        robot.delay(1000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    //Functions

    //Robot functions
    public void type(int i) throws AWTException{
        Robot robot = new Robot();
        robot.delay(60);
        robot.keyPress(i);
        robot.keyRelease(i);
    }
    public static void type(String s) throws AWTException{
        Robot robot = new Robot();
        byte[] bytes = s.getBytes();
        for (byte b : bytes){
            int code = b;
// keycode only handles [A-Z] (which is ASCII decimal [65-90])
            if (code > 96 && code < 123)
                code = code - 32;
            robot.delay(100);
            robot.keyPress(code);
            robot.keyRelease(code);
        }
    }

}