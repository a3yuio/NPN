package per.yyu.testing.gamebase.coupon.action;

import per.yyu.testing.gamebase.coupon.model.CouponTestingModel;
import per.yyu.testing.gamebase.coupon.util.FileIOUtil;
import per.yyu.testing.gamebase.coupon.util.HTTPUtil;
import per.yyu.testing.gamebase.coupon.util.JSONUtil;
import per.yyu.testing.gamebase.coupon.util.POIUtil;

import java.util.Scanner;

public class CouponTestingAction {
    private CouponTestingModel couponTestingModel = new CouponTestingModel();
    private FileIOUtil fileIOUtil;
    private POIUtil poiUtil;
    private JSONUtil jsonUtil;
    private HTTPUtil httpUtil;

    public CouponTestingAction() {
        fileIOUtil = new FileIOUtil();
        fileIOUtil.setCouponTestingInfo_FromTXTFile(couponTestingModel);
    }

    public void serialCouponAutoConsumeTesting() {
        poiUtil = new POIUtil();
        poiUtil.pickupCouponCodes_FromCouponListFile(couponTestingModel, couponTestingModel.getDownloadedCouponListFilePath());

        httpUtil = new HTTPUtil();
        httpUtil.couponConsumePostSend_SerialCoupon(couponTestingModel);

        jsonUtil = new JSONUtil();
        jsonUtil.analysisCouponConsumeResponse(couponTestingModel, couponTestingModel.getCouponListSize() - 1);
        poiUtil.recordCouponConsumeTestingResults_SerialCoupon(couponTestingModel, couponTestingModel.getDownloadedCouponListFilePath());
    }

    public void keywordCouponAutoConsumeTesting() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input 'Keyword coupon code' : ");
        couponTestingModel.setKeywordCouponCode(scanner.nextLine());
        System.out.println("How many consume ?");
        couponTestingModel.setKeywordCouponSize(scanner.nextInt());

        httpUtil = new HTTPUtil();
        httpUtil.couponConsumePostSend_KeywordCoupon(couponTestingModel);

        jsonUtil = new JSONUtil();
        jsonUtil.analysisCouponConsumeResponse(couponTestingModel, couponTestingModel.getKeywordCouponSize());

        poiUtil = new POIUtil();
        poiUtil.recordCouponConsumeTestingResults_KeywordCoupon(couponTestingModel, "C:\\test.xls");
    }
}