package per.yyu.testing.gamebase.javascript.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import per.yyu.testing.gamebase.javascript.model.JavaScriptTestingModel;

public class WebDriverUtil {
    private WebDriver webDriver;

    private String browserMainWindow;
    private String browserSubWindow;

    public WebDriverUtil() {
        this.browserMainWindow = "";
        this.browserSubWindow = "";
    }

    public void chromeTest(JavaScriptTestingModel javaScriptTestingModel) {
        try {
            System.setProperty("webdriver.chrome.driver", javaScriptTestingModel.getChromeDriverFilePath());
            webDriver = new ChromeDriver();

            webDriver.manage().deleteAllCookies();
            webDriver.manage().window().maximize();
            webDriver.get(javaScriptTestingModel.getGamebaseJavaScriptTestingURL());

            Thread.sleep(3000);

            webDriver.close();
            webDriver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
