package per.yyu.testing.gamebase.javascript;

import per.yyu.testing.gamebase.javascript.action.JavaScriptTestingAction;
import per.yyu.testing.gamebase.javascript.model.JavaScriptTestingModel;

import java.util.Scanner;

public class GamebaseJavaScriptTestingMain {
    public static void main(String[] args) {
        JavaScriptTestingModel javaScriptTestingModel = new JavaScriptTestingModel();
        
        JavaScriptTestingAction javaScriptTestingAction = new JavaScriptTestingAction();
        javaScriptTestingAction.javaScriptAutomationTesting(javaScriptTestingModel);

        Scanner scanner = new Scanner(System.in);
    }
}
