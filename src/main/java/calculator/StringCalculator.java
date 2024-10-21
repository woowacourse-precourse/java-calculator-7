package calculator;

import java.util.regex.Pattern;
import java.lang.String;

public class StringCalculator {

    public int calc(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] numbers = splitInput(input);
        return sumNumbers(numbers);
    }

    private String[] splitInput(String input) {
        String delimiter = ",|:"; // 기본 구분자
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");
            delimiter = Pattern.quote(input.substring(2, delimiterIndex));
            input = input.substring(delimiterIndex + 1);
        }

        return input.split(delimiter);
    }

    private int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int num;
            try {
                num = Integer.parseInt(number);
            } catch(NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + number);
            }

            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
            }

            sum += num;
        }

        return sum;
    }
}