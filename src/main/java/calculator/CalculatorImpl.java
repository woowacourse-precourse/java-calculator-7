package calculator;

import java.util.Arrays;

public class CalculatorImpl implements Calculator {
    @Override
    public int plus(String str) {
        CalculatorFactory calculatorFactory = new CalculatorFactory();
        CalculatorVerify calculatorVerify = new CalculatorVerify();

        int[] numberArray = calculatorFactory.splitStringToNumbers(str);  //숫자 추출

        calculatorVerify.isVerifySuccess(numberArray); //추출된 숫자가 계산 가능한 상태인지 검사
        return Arrays.stream(numberArray).sum();
    }
}
