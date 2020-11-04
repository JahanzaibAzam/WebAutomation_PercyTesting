package utils;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class LogHelper {
    private static Logger log = LogManager.getLogger("### "); //Concatenate project name here as well for logging (From Config File)
    final Level VERBOSE = Level.forName("VERBOSE", 200);

    protected void logInfo(String comment) {
        log.info(comment + "\n");
    }

    public static void logStep(String comment) {
        log.info("STEP: " + comment + "\n");
        // WebDriverFactory.saveAllureScreenshot();
    }

    protected void logVerifyTrue(String comment, Object expected, Object actual) {
        log.info(comment + "\n");
        Assert.assertEquals(comment,expected, actual);
    }

    protected void logVerifyContains(String comment, String actual, String expected) {
        log.info(comment + "\n");
        Assert.assertTrue(comment,actual.contains(expected));

    }

    protected void logVerifyTrue(String comment, Object[] actual, Object[] expected) {
        log.info(comment + "\n");
        for(int i=0;i<actual.length;i++)
            Assert.assertEquals(comment,expected[i], actual[i]);

    }

    protected void logVerifyTrue(String comment, Object actual) {
        log.info(comment + "\n");
        Assert.assertEquals(comment,true,actual);
    }

    protected void logVerifyFalse(String comment, Object actual) {
        log.info(comment + "\n");
        Assert.assertEquals(comment,false,actual);
    }

    protected void logVerifyFalse(String comment, Object actual, Object expected) {
        log.info(comment+ "\n");
        Assert.assertFalse(comment,actual.equals(expected));
    }

    protected void logVerifyNull(String comment, Object actual) {
        log.info(comment+ "\n");
        Assert.assertNull(comment,actual);
    }

    protected void logVerifyNotNull(String comment, Object actual) {
        log.info(comment+ "\n");
        Assert.assertNotNull(comment,actual);
    }

}
