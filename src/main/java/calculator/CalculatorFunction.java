package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorFunction {
    // String => Int
    public int ConvertNum(String input) {
        try {
            int num = Integer.parseInt(input);
            if (num < 0) {
                throw new IllegalArgumentException();
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException();
        }

        String delimiter = "[,:]"; // 기본 구분자
        String numbers = input;


        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
            if (m.find()) {
                delimiter = Pattern.quote(m.group(1)); // 커스텀 구분자 추출
                numbers = m.group(2); // 숫자 부분 추출
            }
        }

        // 구분자를 기준으로 숫자를 분리
        String[] tokens = numbers.split(delimiter);
        int sum = 0;

        for (String token : tokens) {
            sum += ConvertNum(token); // 숫자로 변환하여 더하기
        }

        return sum;
    }
}
