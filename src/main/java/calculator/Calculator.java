package calculator;

import java.util.regex.Pattern;

public class Calculator {

    private static final String DEFAULT_DELIMITER = ",|:";

    public int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = DEFAULT_DELIMITER;
        String numbers = input;

        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");
            if (delimiterIndex == -1) {
                throw new IllegalArgumentException("잘못된 형식입니다. 커스텀 구분자를 지정하려면 '\\n'이 포함되어야 합니다.");
            }
            delimiter = Pattern.quote(input.substring(2, delimiterIndex));
            numbers = input.substring(delimiterIndex + 2);
        }

        return sum(numbers.split(delimiter));
    }

    private int sum(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            if (number.isEmpty()) continue;

            int parsedNumber = Integer.parseInt(number);

            if (parsedNumber < 0) {
                throw new IllegalArgumentException("음수를 입력할 수 없습니다.");
            }

            total += parsedNumber;
        }
        return total;
    }
}