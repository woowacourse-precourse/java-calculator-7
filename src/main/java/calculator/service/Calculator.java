package calculator.service;

import java.math.BigDecimal;
import java.math.BigInteger;

// 숫자들의 합을 구해 반환하기 위한 클래스
public class Calculator {

    // 숫자들의 합을 구해 반환하는 메소드
    public static String calculateSum(String[] numbers) {
        if(checkInteger(numbers)) {
            return calculateInteger(numbers);
        }
        return calculateRationalNumber(numbers);
    }

    // 정수인지 아닌지 판별하는 메소드
    public static boolean checkInteger(String[] numbers){
        for (String number : numbers) {
            if(number.contains(".")){
                return false;
            }
        }
        return true;
    }

    // 정수의 합을 구해 반환하는 메소드
    public static String calculateInteger(String[] numbers){
        BigInteger sum = BigInteger.ZERO;

        for (String number : numbers) {
            sum = sum.add(new BigInteger(number));
        }

        return sum.toString();
    }

    // 정수가 아닌 실수가 포함돼 있을 때, 합을 구해 반환하는 메소드
    public static String calculateRationalNumber(String[] numbers){
        BigDecimal sum = BigDecimal.ZERO;

        for (String number : numbers) {
            sum = sum.add(new BigDecimal(number));
        }

        return sum.toString();
    }
}
