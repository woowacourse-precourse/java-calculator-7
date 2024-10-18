package calculator;

import java.util.Arrays;

public class StringCalculator {
    public int add(String input) {
        try {
            if (input.startsWith("//")) {
                int delimiterIndex = input.indexOf("\n");
                String customDelimiter = input.substring(2, delimiterIndex);
                input = input.substring(delimiterIndex + 1);
                return Arrays.stream(input.split(customDelimiter)).mapToInt(Integer::parseInt).sum();
            }
            return Arrays.stream(input.split("[,|:]")).mapToInt(Integer::parseInt).sum();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력 값입니다.");
        }
    }
}

