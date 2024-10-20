package calculator.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static calculator.domain.CustomDelimiter.*;
import static calculator.domain.NumberExtractor.getIntegerArray;
import static calculator.domain.Result.getResult;
import static calculator.validator.NumberValidator.areAllPositiveIntegers;
import static calculator.validator.StringValidator.hasCustomDelimiter;

public class Calculator{
    ArrayList<String> delimiter; // 구분자를 저장할 리스트
    String input;

    public Calculator(String input) {
        this.input = input;
        delimiter = new ArrayList<>(Arrays.asList(",", ":")); // 기본 구분자 (,)와 (:)을 저장
    }
    public int calculate() {
        // 커스텀문자열이 존재할 경우
        if (hasCustomDelimiter(input)) {
            delimiter.add(getCustomDelimiter(input)); // 커스텀 구분자를 delimiter 리스트에 저장
            input = removeCustomDelimiter(input); // 구분자 양식을 제거하여 input에 다시 저장
        }
        areAllPositiveIntegers(input, delimiter); // 모든 값이 양의 정수인지 판단

        return getResult(getIntegerArray(input, delimiter));
    }
}
