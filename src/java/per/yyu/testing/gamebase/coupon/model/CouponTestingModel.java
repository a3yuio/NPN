package per.yyu.testing.gamebase.coupon.model;

import java.util.ArrayList;

public class CouponTestingModel {
    private String couponTestingInfoFilePath;

    // Coupon Testing Infos
    private String toastProjectAppID;
    private String gamebaseUserID;
    private String downloadedCouponListFilePath;
    private String gamebaseServerAPIDomain;
    private String[][] gamebaseServerAPIHTTPHeaderOption;

    private int couponListSize;
    private ArrayList<String> couponCodes;
    private ArrayList<String> gamebaseServerResponses;
    private ArrayList<String> couponConsumeIsSuccessful;
    private int benefitItemSize;
    private ArrayList<String> couponConsumeTestingResult;

    public CouponTestingModel() {
        this.couponTestingInfoFilePath = "D:\\NPN\\src\\resource\\coupon\\CouponInfo.txt";

        this.toastProjectAppID = null;
        this.gamebaseUserID = null;
        this.downloadedCouponListFilePath = null;
        this.gamebaseServerAPIDomain = null;
        this.gamebaseServerAPIHTTPHeaderOption = new String[2][2];

        this.couponListSize = 0;
        this.couponCodes = new ArrayList<>();
        this.gamebaseServerResponses = new ArrayList<>();
        this.couponConsumeIsSuccessful = new ArrayList<>();
        this.benefitItemSize = 0;
        this.couponConsumeTestingResult = new ArrayList<>();
    }

    public String getCouponTestingInfoFilePath() {
        return this.couponTestingInfoFilePath;
    }

    public String getDownloadedCouponListFilePath() {
        return this.downloadedCouponListFilePath;
    }

    public void setDownloadedCouponListFilePath(String path) {
        this.downloadedCouponListFilePath = path;
    }

    public String getToastProjectAppID() {
        return this.toastProjectAppID;
    }

    public void setToastProjectAppID(String appID) {
        this.toastProjectAppID = appID;
    }

    public String getGamebaseUserID() {
        return this.gamebaseUserID;
    }

    public void setGamebaseUserID(String userID) {
        this.gamebaseUserID = userID;
    }

    public ArrayList<String> getCouponCodes() {
        return this.couponCodes;
    }

    public void setCouponCodes(ArrayList<String> couponCodes) {
        this.couponCodes = couponCodes;
    }

    public int getCouponListSize() {
        return this.couponListSize;
    }

    public void setCouponListSize(int size) {
        this.couponListSize = size;
    }

    public String getGamebaseServerAPIDomain() {
        return this.gamebaseServerAPIDomain;
    }

    public void setGamebaseServerAPIDomain(String url) {
        this.gamebaseServerAPIDomain = url;
    }

    public String getGamebaseServerAPIHTTPHeaderOptionName(int index) {
        return this.gamebaseServerAPIHTTPHeaderOption[index][0];
    }

    public void setGamebaseServerAPIHTTPHeaderOptionName(int index, String value) {
        this.gamebaseServerAPIHTTPHeaderOption[index][0] = value;
    }

    public String getGamebaseServerAPIHTTPHeaderOptionValue(int index) {
        return this.gamebaseServerAPIHTTPHeaderOption[index][1];
    }

    public void setGamebaseServerAPIHTTPHeaderOptionValue(int index, String value) {
        this.gamebaseServerAPIHTTPHeaderOption[index][1] = value;
    }

    public ArrayList<String> getGamebaseServerResponses() {
        return this.gamebaseServerResponses;
    }

    public void setGamebaseServerResponses(ArrayList<String> responses) {
        this.gamebaseServerResponses = responses;
    }

    public ArrayList<String> getCouponConsumeIsSuccessful() {
        return this.couponConsumeIsSuccessful;
    }

    public void setCouponConsumeIsSuccessful(ArrayList<String> successful) {
        this.couponConsumeIsSuccessful = successful;
    }

    public int getBenefitItemSize() {
        return this.benefitItemSize;
    }

    public void setBenefitItemSize(int size) {
        this.benefitItemSize = size;
    }

    public ArrayList<String> getCouponConsumeTestingResult() {
        return this.couponConsumeTestingResult;
    }

    public void setCouponConsumeTestingResult(ArrayList<String> results) {
        this.couponConsumeTestingResult = results;
    }
}