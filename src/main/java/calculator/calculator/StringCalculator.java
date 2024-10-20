package calculator.calculator;

import calculator.extractor.NumberExtractor;

import java.util.ArrayList;

public class StringCalculator extends Calculator {
    private String inputData; // 입력된 문자열

    public StringCalculator(String inputData) {
        this.inputData = inputData;
    }

    @Override
    public int sum() {
        // 1. 문자열에서 숫자 배열 추출
        ArrayList<Integer> numberList = NumberExtractor.extractNumberList(inputData);

        // 2. 추출된 숫자에 대해서 더하기 연산 수행 후 결과값 반환
        Integer result = 0; // 계산 결과
        for (Integer i : numberList) {
            result += i;
        }
        return result;
    }
}
