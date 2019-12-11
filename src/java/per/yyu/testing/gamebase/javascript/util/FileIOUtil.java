package per.yyu.testing.gamebase.javascript.util;

import per.yyu.testing.gamebase.javascript.model.JavaScriptTestingModel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class FileIOUtil {
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private FileReader fileReader;

    public void setJavaScriptTestingInfo_FromTXTFile(JavaScriptTestingModel javaScriptTestingModel) {
        try {
            // Set Gamebase JavaScript Testing URL
            fileReader = new FileReader(new File(javaScriptTestingModel.getJavaScriptTestingURLFilePath()));
            bufferedReader = new BufferedReader(fileReader);

            javaScriptTestingModel.setGamebaseJavaScriptTestingURL(bufferedReader.readLine());

            // Set Gamebase JavaScript Testing ID / PW
            fileReader = new FileReader(new File(javaScriptTestingModel.getJavaScriptTestingInfoFilePath()));
            bufferedReader = new BufferedReader(fileReader);

            ArrayList<String> idList = new ArrayList<>();
            ArrayList<String> pwList = new ArrayList<>();

            int listIndex = 0;
            int readCount = 1;
            String line = "";

            while ((line = bufferedReader.readLine()) != null) {
                if(readCount % 2 != 0) {
                    idList.add(listIndex, line);
                } else {
                    pwList.add(listIndex, line);
                    listIndex++;
                }
                readCount++;
            }

            javaScriptTestingModel.setTestingID(idList);
            javaScriptTestingModel.setTestingPW(pwList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (Exception ignored) {

            }
        }
    }
}