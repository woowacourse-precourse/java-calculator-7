package calculator;

import java.util.regex.Pattern;

public class Calculator {
    public static int add(String input) {
        if (input == null || input.equals("")) {
            return 0;
        }

        input = input.replace("\\n", "\n");

        String[] numbers = splitInput(input);
        int sum = 0;

        for (String numberStr : numbers) {
            int number = toPositiveNumber(numberStr);
            sum += number;
        }

        return sum;
    }

    private static String[] splitInput(String input) {
        String delimiter = ",|:";

        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("구분자 지정이 올바르지 않습니다.");
            }
            delimiter = input.substring(2, delimiterEndIndex);
            input = input.substring(delimiterEndIndex + 1);
        }

        return input.split(Pattern.quote(delimiter));
    }

    private static int toPositiveNumber(String str) {
        int number;
        try {
            number = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식이 올바르지 않습니다.");
        }

        if (number < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }

        return number;
    }
}
