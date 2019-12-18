package per.yyu.testing.gamebase.coupon;

import per.yyu.testing.gamebase.coupon.action.CouponTestingAction;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CouponTestingAction couponTestingAction = new CouponTestingAction();
        Scanner scanner = new Scanner(System.in);

        System.out.println("What do you want?");
        System.out.println("1. 'Serial' coupon consume testing");
        System.out.println("2. 'Keyword' coupon consume testing");

        switch (scanner.nextInt()) {
            case 1: {
                couponTestingAction.serialCouponAutoConsumeTesting();
                break;
            }
            case 2: {
                couponTestingAction.keywordCouponAutoConsumeTesting();
                break;
            }
        }
    }
}