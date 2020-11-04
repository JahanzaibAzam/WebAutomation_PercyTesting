package config;

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource.Classpath;

@Classpath({"ApplicationConfig.properties"})
public class ApplicationConfigReader {
    @Property("username")
    private String UserName;

    @Property("password")
    private String Password;

    @Property("Environment")
    private String Environment;

    @Property("Device")
    private String Device;

    @Property("headless")
    private String headless;

    @Property("Browser")
    private String Browser;

     @Property("baseURI")
    private String baseURI;

     @Property("url")
    private String url;

    @Property("LogTestRail")
    private String LogTestRail;

    @Property("LogJIRA")
    private String LogJIRA;


    @Property("UpdateCase")
    private String UpdateCase;

    @Property("TemplateId")
    private String TemplateId;

    @Property("isEnableReporting")
    private String isEnableReporting;

    @Property("isEnableRecording")
    private String isEnableRecording;

/*############################ --- Environment --- ############################*/

    @Property("dbName")
    private String dbName = "";

    @Property("dbUrl")
    private String dbUrl = "";

    @Property("dbUsername")
    private String dbUsername = "";

    @Property("dbPassword")
    private String dbPassword = "";


    public ApplicationConfigReader() {
        PropertyLoader.newInstance().populate(this);
    }

    public String getUserName() {
        return this.UserName;
    }
    public String getPassword() {
        return this.Password;
    }

    public String getEnvironment() {
        return this.Environment;
    }

    public String getDevice() {
        return this.Device;
    }

    public String getHeadless() {
        return this.headless;
    }

    public String getBrowser() {
        return this.Browser;
    }

    public String getBaseURI() {
        return this.baseURI;
    }
    public String getUrl() {
        return this.url;
    }

    public String getIsEnableReporting() { return this.isEnableReporting; }
    public String getIsEnableRecording() { return this.isEnableRecording; }


    public String getDbName() {
        return dbName;
    }
    public String getDbUrl() {
        return dbUrl;
    }
    public String getDbUsername() { return dbUsername; }
    public String getDbPassword() { return dbPassword; }
    public String getLogTestRail() { return LogTestRail; }
    public String getLogJIRA() { return LogJIRA; }


    public String getTemplateId() {
        return this.TemplateId;
    }

    public String getUpdateCase() {
        return this.UpdateCase;
    }



}
