package per.yyu.testing.gamebase.javascript.model;

import java.util.ArrayList;
import java.util.List;

public class JavaScriptTestingModel {
    private String javaScriptTestingURLFilePath;
    private String javaScriptTestingInfoFilePath;

    private String chromeDriverFilePath;
    private String geckoDriverFilePath;
    private String ieDriverFilePath;

    private String gamebaseJavaScriptTestingURL;

    private List<String> testingID;
    private List<String> testingPW;

    public JavaScriptTestingModel() {
        this.javaScriptTestingURLFilePath = "D:\\NPN\\src\\resource\\javascript\\GamebaseJavaScriptTestingURL.txt";
        this.javaScriptTestingInfoFilePath = "D:\\NPN\\src\\resource\\javascript\\GamebaseJavaScriptTestingInfo.txt";

        this.chromeDriverFilePath = "D:\\NPN\\src\\resource\\javascript\\chromedriver.exe";
        this.geckoDriverFilePath = "D:\\NPN\\src\\resource\\javascript\\geckodriver.exe";
        this.ieDriverFilePath = "D:\\NPN\\src\\resource\\javascript\\IEDriverServer.exe";

        this.gamebaseJavaScriptTestingURL = "";

        this.testingID = new ArrayList<>();
        this.testingPW = new ArrayList<>();
    }

    public String getJavaScriptTestingURLFilePath() {
        return this.javaScriptTestingURLFilePath;
    }

    public String getJavaScriptTestingInfoFilePath() {
        return this.javaScriptTestingInfoFilePath;
    }

    public String getChromeDriverFilePath() {
        return this.chromeDriverFilePath;
    }

    public String getGeckoDriverFilePath() {
        return this.geckoDriverFilePath;
    }

    public String getIeDriverFilePath() {
        return this.ieDriverFilePath;
    }

    public void setGamebaseJavaScriptTestingURL(String url) {
        this.gamebaseJavaScriptTestingURL = url;
    }

    public String getGamebaseJavaScriptTestingURL() {
        return this.gamebaseJavaScriptTestingURL;
    }

    public void setTestingID(ArrayList<String> idList) {
        this.testingID = idList;
    }

    public List<String> getTestingID() {
        return this.testingID;
    }

    public void setTestingPW(ArrayList<String> pwList) {
        this.testingPW = pwList;
    }

    public List<String> getTestingPW() {
        return this.testingPW;
    }
}