package per.yyu.testing.gamebase.coupon.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import per.yyu.testing.gamebase.coupon.model.CouponTestingModel;

import java.util.ArrayList;

public class JSONUtil {
    private JSONParser jsonParser;

    public JSONUtil() {
        this.jsonParser = new JSONParser();
    }

    public void analysisCouponConsumeResponse(CouponTestingModel couponTestingModel) {
        try {
            ArrayList<String> couponConsumeResponses = couponTestingModel.getGamebaseServerResponses();
            ArrayList<String> consumeIsSuccessfulResults = new ArrayList<>();
            ArrayList<String> consumeTestingResults = new ArrayList<>();
            ArrayList<String> benefitItems = new ArrayList<>();

            // 쿠폰 사이즈는 카테고리까지 포함하므로, 카테고리를 뺀 만큼 수량까지 Response Analysis 를 수행한다.
            for(int analysisCount = 0; analysisCount < couponTestingModel.getCouponListSize() - 1; analysisCount++) {
                JSONObject originObj = (JSONObject) jsonParser.parse(couponConsumeResponses.get(analysisCount));
                JSONObject headerObj = (JSONObject) originObj.get("header");

                if(headerObj.get("isSuccessful").equals(true)) {
                    consumeIsSuccessfulResults.add(analysisCount, "PASS");

                    JSONObject resultObj = (JSONObject) originObj.get("result");
                    JSONArray benefitsArray = (JSONArray) resultObj.get("benefits");
                    couponTestingModel.setBenefitItemSize(benefitsArray.size());

                    for (int itemCount = 0; itemCount < couponTestingModel.getBenefitItemSize(); itemCount++) {
                        JSONObject benefitsObj = (JSONObject) benefitsArray.get(itemCount);
                        benefitItems.add(itemCount, benefitsObj.get("itemId") + " : " + benefitsObj.get("amount") + "\n");
                    }
                    consumeTestingResults.add(analysisCount, benefitItems.toString());
                    benefitItems.clear();
                } else {
                    consumeIsSuccessfulResults.add(analysisCount, "FAIL");
                    consumeTestingResults.add(analysisCount, headerObj.get("resultCode") + " : " + headerObj.get("resultMessage"));
                }
            }
            couponTestingModel.setCouponConsumeIsSuccessful(consumeIsSuccessfulResults);
            couponTestingModel.setCouponConsumeTestingResult(consumeTestingResults);

            System.out.println("[JSON Util] : " + couponTestingModel.getCouponConsumeIsSuccessful());
            System.out.println("[JSON Util] : " + couponTestingModel.getCouponConsumeTestingResult());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}