package per.yyu.testing.gamebase.coupon.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import per.yyu.testing.gamebase.coupon.model.CouponTestingModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class POIUtil {
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;
    private File file;
    private HSSFWorkbook hssfWorkbook;
    private HSSFSheet hssfSheet;
    private HSSFRow hssfRow;
    private HSSFCell hssfCell;
    private Row row;

    public void pickupCouponCodes_FromCouponListFile(CouponTestingModel couponTestingModel, String filePath) {
        try {
            fileInputStream = new FileInputStream(filePath);
            hssfWorkbook = new HSSFWorkbook(fileInputStream);
            // 쿠폰 리스트 파일의 첫 번째 시트를 봐야하기 때문에, index = 0 으로 고정한다.
            hssfSheet = hssfWorkbook.getSheetAt(0);
            couponTestingModel.setCouponListSize(hssfSheet.getPhysicalNumberOfRows());

            ArrayList<String> couponCodes_FromCouponListFile = new ArrayList<>();

            // 엑셀 파일의 첫 번째 행에는 카테고리 이름이 있으므로, index = 1 (두 번째 줄) 부터 값을 가져온다.
            for (int rowIndex = 1; rowIndex < couponTestingModel.getCouponListSize(); rowIndex++) {
                hssfRow = hssfSheet.getRow(rowIndex);
                // 첫 번째 열에만 Coupon Code 가 있으므로, cellnum = 0 으로 고정한다.
                hssfCell = hssfRow.getCell(0);

                switch (hssfCell.getCellType()) {
                    case XSSFCell.CELL_TYPE_FORMULA:
                        couponCodes_FromCouponListFile.add(rowIndex - 1, hssfCell.getCellFormula());
                        break;
                    case XSSFCell.CELL_TYPE_NUMERIC:
                        couponCodes_FromCouponListFile.add(rowIndex - 1, hssfCell.getNumericCellValue() + "");
                        break;
                    case XSSFCell.CELL_TYPE_STRING:
                        couponCodes_FromCouponListFile.add(rowIndex - 1, hssfCell.getStringCellValue());
                        break;
                    case XSSFCell.CELL_TYPE_BLANK:
                        couponCodes_FromCouponListFile.add(rowIndex - 1, hssfCell.getBooleanCellValue() + "");
                        break;
                    case XSSFCell.CELL_TYPE_ERROR:
                        couponCodes_FromCouponListFile.add(rowIndex - 1, hssfCell.getErrorCellValue() + "");
                        break;
                }
            }
            couponTestingModel.setCouponCodes(couponCodes_FromCouponListFile);
            System.out.println("[POI Util] : " + couponTestingModel.getCouponCodes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (Exception ignored) {

            }
        }
    }

    public void recordCouponConsumeTestingResults_SerialCoupon(CouponTestingModel couponTestingModel, String filePath) {
        try {
            ArrayList<String> couponCodes = couponTestingModel.getCouponCodes();
            ArrayList<String> consumeTime = couponTestingModel.getConsumeTestingTimes();
            ArrayList<String> consumeIsSuccessful = couponTestingModel.getCouponConsumeIsSuccessful();
            ArrayList<String> consumeTestingResults = couponTestingModel.getCouponConsumeTestingResult();

            // 엑셀 파일의 첫 번째 행에는 카테고리 이름이 있으므로, rowIndex = 1 (두 번째 행) 부터 값을 기록한다.
            for (int rowIndex = 1; rowIndex < couponTestingModel.getCouponListSize(); rowIndex++) {
                row = hssfSheet.createRow(rowIndex);

                // 첫 번째 열에는 쿠폰 코드를 기록한다.
                row.createCell(0).setCellValue(couponCodes.get(rowIndex - 1));
                // 두 번쨰 열에는 Coupon 을 Consume 한 시간을 기록한다.
                row.createCell(1).setCellValue(consumeTime.get(rowIndex - 1));
                // 세 번째 열에는 Coupon Consume 성공 여부를 기록한다.
                row.createCell(2).setCellValue(consumeIsSuccessful.get(rowIndex - 1));
                // 네 번째 열에는 결과를 기록한다. (아이템 or 에러코드)
                row.createCell(3).setCellValue(consumeTestingResults.get(rowIndex - 1));
            }
            fileOutputStream = new FileOutputStream(filePath);
            hssfWorkbook.write(fileOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                hssfWorkbook.close();
                fileOutputStream.close();
            } catch (Exception ignored) {

            }
        }
    }

    public void recordCouponConsumeTestingResults_KeywordCoupon(CouponTestingModel couponTestingModel, String filePath) {
        try {
            file = new File(filePath);
            if(file.exists() == false) {
                file.createNewFile();
            }
            hssfWorkbook = new HSSFWorkbook();
            hssfSheet = hssfWorkbook.createSheet("Keyword Coupon testing result");
            hssfSheet.setColumnWidth(0, 6900);
            hssfSheet.setColumnWidth(1, 5500);
            hssfSheet.setColumnWidth(2, 10000);

            ArrayList<String> consumeTime = couponTestingModel.getConsumeTestingTimes();
            ArrayList<String> consumeIsSuccessful = couponTestingModel.getCouponConsumeIsSuccessful();
            ArrayList<String> consumeTestingResults = couponTestingModel.getCouponConsumeTestingResult();

            // 엑셀 파일의 첫 번째 행에는 카테고리 이름을 기록한다.
            row = hssfSheet.createRow(0);
            row.createCell(0).setCellValue("Consume Time");
            row.createCell(1).setCellValue("Consume Successful");
            row.createCell(2).setCellValue("Test Result");

            // 두 번째 행부터 테스트 결과를 기록한다.
            for (int rowIndex = 1; rowIndex < couponTestingModel.getKeywordCouponSize(); rowIndex++) {
                row = hssfSheet.createRow(rowIndex);

                // 첫 번쨰 열에는 Coupon 을 Consume 한 시간을 기록한다.
                row.createCell(0).setCellValue(consumeTime.get(rowIndex - 1));
                // 두 번째 열에는 Coupon Consume 성공 여부를 기록한다.
                row.createCell(1).setCellValue(consumeIsSuccessful.get(rowIndex - 1));
                // 세 번째 열에는 결과를 기록한다. (아이템 or 에러코드)
                row.createCell(2).setCellValue(consumeTestingResults.get(rowIndex - 1));
            }
            fileOutputStream = new FileOutputStream(file);
//            fileOutputStream = new FileOutputStream(filePath);
            hssfWorkbook.write(fileOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                hssfWorkbook.close();
                fileOutputStream.close();
            } catch (Exception ignored) {

            }
        }
    }
}