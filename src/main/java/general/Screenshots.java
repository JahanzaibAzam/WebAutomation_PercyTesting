package general;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Screenshots {

    public static File screenShot;
    public static final String takeScreenshot(String test) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_hh-mm-ss"); //colon removed, windows not support colon
        Calendar now = Calendar.getInstance();

        String filePath = System.getProperty("user.dir") + "/screenshots/" + test + "_" + formatter.format(now.getTime())+".jpg";

        try {
            File scrFile = ((TakesScreenshot)WebDriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(filePath));
        } catch (IOException e) {
            filePath = "Failed to capture screenshot: " + e.getMessage();
            e.printStackTrace();
        }

       filePath = filePath.replace(System.getProperty("user.dir"), "..");
        return filePath;
    }

    public static String getScreenshot(String screenshotName) throws Exception {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) WebDriverFactory.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);

        //after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName + ".jpg";

        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);

        return destination;
    }
}
