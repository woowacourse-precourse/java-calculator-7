package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterCalculator {
    public int sum;

    public CustomDelimiterCalculator(String delimiter, String input) {
        String[] numbers = input.split(delimiter);
        sum = 0;
        // 숫자가 아닌 값이 포함되어 있는지 확인 및 합계 계산
        for (String number : numbers) {
            try {
                int value = Integer.parseInt(number);  // 숫자로 변환 시도
                sum += value;  // 변환에 성공하면 합계에 더함
            } catch (NumberFormatException e) {
                // 변환에 실패하면 IllegalArgumentException 발생
                throw new IllegalArgumentException("Invalid input: " + number);
            }
        }
    }
}