package per.yyu.testing.gamebase.javascript.action;

import per.yyu.testing.gamebase.javascript.model.JavaScriptTestingModel;
import per.yyu.testing.gamebase.javascript.util.FileIOUtil;
import per.yyu.testing.gamebase.javascript.util.WebDriverUtil;

public class JavaScriptTestingAction {
    FileIOUtil fileIOUtil = new FileIOUtil();
    WebDriverUtil webDriverUtil = new WebDriverUtil();

    public void javaScriptAutomationTesting(JavaScriptTestingModel javaScriptTestingModel) {
        fileIOUtil.setJavaScriptTestingInfo_FromTXTFile(javaScriptTestingModel);
        webDriverUtil.chromeTest(javaScriptTestingModel);
    }
}
