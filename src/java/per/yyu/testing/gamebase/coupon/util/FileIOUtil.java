package per.yyu.testing.gamebase.coupon.util;

import per.yyu.testing.gamebase.coupon.model.CouponTestingModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileIOUtil {
    private FileReader fileReader;
    private BufferedReader bufferedReader;

    public void setCouponTestingInfo_FromTXTFile(CouponTestingModel couponTestingModel) {
        try {
            fileReader = new FileReader(new File(couponTestingModel.getCouponTestingInfoFilePath()));
            bufferedReader = new BufferedReader(fileReader);

            couponTestingModel.setToastProjectAppID(bufferedReader.readLine());
            couponTestingModel.setGamebaseUserID(bufferedReader.readLine());
            couponTestingModel.setDownloadedCouponListFilePath(bufferedReader.readLine());
            couponTestingModel.setGamebaseServerAPIDomain(bufferedReader.readLine());
            couponTestingModel.setGamebaseServerAPIHTTPHeaderOptionName(0, bufferedReader.readLine());
            couponTestingModel.setGamebaseServerAPIHTTPHeaderOptionValue(0, bufferedReader.readLine());
            couponTestingModel.setGamebaseServerAPIHTTPHeaderOptionName(1, bufferedReader.readLine());
            couponTestingModel.setGamebaseServerAPIHTTPHeaderOptionValue(1, bufferedReader.readLine());

            System.out.println("[File Util] Downloaded Coupon List File Path : " + couponTestingModel.getDownloadedCouponListFilePath());
            System.out.println("[File Util] Toast App ID : " + couponTestingModel.getToastProjectAppID());
            System.out.println("[File Util] Gamebase User ID : " + couponTestingModel.getGamebaseUserID());
            System.out.println("[File Util] Server API Domain : " + couponTestingModel.getGamebaseServerAPIDomain());
            System.out.println("[File Util] HTTP Header Option 1 : " + couponTestingModel.getGamebaseServerAPIHTTPHeaderOptionName(0) + " ; " + couponTestingModel.getGamebaseServerAPIHTTPHeaderOptionValue(0));
            System.out.println("[File Util] HTTP Header Option 2 : " + couponTestingModel.getGamebaseServerAPIHTTPHeaderOptionName(1) + " ; " + couponTestingModel.getGamebaseServerAPIHTTPHeaderOptionValue(1));
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