package calculator.validator;

import java.util.ArrayList;

import static calculator.domain.ValueExtractor.getDelimitedValue;

public class NumberValidator{
    public static boolean areAllPositiveIntegers(String input, ArrayList<String> delimiter) {

        for (String value : getDelimitedValue(input, delimiter)) {
            if (!isPositiveInteger(value)) {
                throw new IllegalArgumentException("양의 정수가 아닙니다: " + value);
            }
        }
        return true;
    }

    public static boolean isPositiveInteger(String value) {
        try {
            int convert = Integer.parseInt(value); // 문자열을 정수로 변환
            return convert > 0; // 0보다 큰지 확인
        } catch (NumberFormatException e) {
            return false; // 숫자가 아닐 경우 false 반환
        }
    }
}
