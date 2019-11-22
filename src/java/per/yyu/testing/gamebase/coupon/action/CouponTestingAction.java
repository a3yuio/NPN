package per.yyu.testing.gamebase.coupon.action;

import per.yyu.testing.gamebase.coupon.model.CouponTestingModel;
import per.yyu.testing.gamebase.coupon.util.FileIOUtil;
import per.yyu.testing.gamebase.coupon.util.HTTPUtil;
import per.yyu.testing.gamebase.coupon.util.JSONUtil;
import per.yyu.testing.gamebase.coupon.util.POIUtil;

public class CouponTestingAction {
    private CouponTestingModel couponTestingModel = new CouponTestingModel();
    private FileIOUtil fileIOUtil;
    private POIUtil poiUtil;
    private JSONUtil jsonUtil;
    private HTTPUtil httpUtil;

    public void couponAutoConsumeTesting() {
        fileIOUtil = new FileIOUtil();
        fileIOUtil.setCouponTestingInfo_FromTXTFile(couponTestingModel);

        poiUtil = new POIUtil();
        poiUtil.pickupCouponCodes_FromCouponListFile(couponTestingModel, couponTestingModel.getDownloadedCouponListFilePath());

        httpUtil = new HTTPUtil();
        httpUtil.couponConsumePostSend(couponTestingModel);

        jsonUtil = new JSONUtil();
        jsonUtil.analysisCouponConsumeResponse(couponTestingModel);
        poiUtil.recordCouponConsumeTestingResults_ToCouponListFile(couponTestingModel, couponTestingModel.getDownloadedCouponListFilePath());
    }
}