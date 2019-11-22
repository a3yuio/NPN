package per.yyu.testing.gamebase.coupon.util;

import per.yyu.testing.gamebase.coupon.model.CouponTestingModel;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class HTTPUtil {
    private HttpURLConnection httpURLConnection;
    private ByteArrayOutputStream byteArrayOutputStream;
    private InputStream inputStream;

    public void couponConsumePostSend(CouponTestingModel couponTestingModel) {
        try {
            ArrayList<String> couponCodes = couponTestingModel.getCouponCodes();
            ArrayList<String> postResponses = new ArrayList<>();

            // 쿠폰 사이즈는 카테고리까지 포함하므로, 카테고리를 뺀 만큼 수량까지 Coupon Consume 을 수행한다.
            for (int couponCount = 0; couponCount < couponTestingModel.getCouponListSize() - 1; couponCount++) {
                URL url = new URL(couponTestingModel.getGamebaseServerAPIDomain() + "/apps/" + couponTestingModel.getToastProjectAppID() + "/members/" + couponTestingModel.getGamebaseUserID() + "/coupons/" + couponCodes.get(couponCount));
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                // HTTP Header
                httpURLConnection.setRequestProperty(couponTestingModel.getGamebaseServerAPIHTTPHeaderOptionName(0), couponTestingModel.getGamebaseServerAPIHTTPHeaderOptionValue(0));
                httpURLConnection.setRequestProperty(couponTestingModel.getGamebaseServerAPIHTTPHeaderOptionName(1), couponTestingModel.getGamebaseServerAPIHTTPHeaderOptionValue(1));
                httpURLConnection.setDoOutput(true);

                int responseCode = httpURLConnection.getResponseCode();
                byteArrayOutputStream = new ByteArrayOutputStream();

                if(responseCode == HttpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();

                    byte[] buf = new byte[1024 * 8];
                    int length = 0;
                    while ((length = inputStream.read(buf)) != -1) {
                        byteArrayOutputStream.write(buf, 0, length);
                    }
                } else {
                    System.out.println("[HTTP Util] : Send HTTP Post Error !!!!!");
                }
                postResponses.add(couponCount, new String(byteArrayOutputStream.toByteArray(), "UTF-8"));
            }
            couponTestingModel.setGamebaseServerResponses(postResponses);
            System.out.println("[HTTP Util] : " + couponTestingModel.getGamebaseServerResponses());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}