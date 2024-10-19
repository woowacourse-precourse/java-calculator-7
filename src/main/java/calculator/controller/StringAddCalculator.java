package calculator.controller;

import java.util.regex.Pattern;

public class StringAddCalculator {
    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
            }
            delimiter = Pattern.quote(input.substring(2, delimiterEndIndex));
            input = input.substring(delimiterEndIndex + 2);
        }

        String[] numbers = input.split(delimiter);
        int result = 0;
        for (String numString : numbers) {
            try {
                int number = Integer.parseInt(numString);
                if (number < 0) {
                    throw new IllegalArgumentException("음수 값이 입력되었습니다: " + number);
                }
                result += number;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 값이 입력되었습니다: " + numString);
            }
        }
        return result;
    }
}
