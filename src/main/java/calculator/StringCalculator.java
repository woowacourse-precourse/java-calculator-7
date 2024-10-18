package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String CUSTOM_DELIMITER_START = "//";
    private static final String CUSTOM_DELIMITER_END = "\\n";
    private static final String DEFAULT_DELIMITERS = ",|:";

    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String[] parsedInput = parseInput(input);
        String delimiter = parsedInput[0];
        String numbers = parsedInput[1];

        return sum(splitNumbers(numbers, delimiter));
    }

    private String[] parseInput(String input) {
        String delimiter = DEFAULT_DELIMITERS;
        String numbers = input;

        int customStart = input.indexOf(CUSTOM_DELIMITER_START);
        int customEnd = input.indexOf(CUSTOM_DELIMITER_END, customStart);

        if (customStart != -1 && customEnd != -1) {
            String customDelimiter = Pattern.quote(input.substring(customStart + CUSTOM_DELIMITER_START.length(), customEnd));
            delimiter = DEFAULT_DELIMITERS + "|" + customDelimiter;
            numbers = input.substring(0, customStart) + input.substring(customEnd + CUSTOM_DELIMITER_END.length());
        }

        return new String[]{delimiter, numbers};
    }

    private String[] splitNumbers(String numbers, String delimiter) {
        return numbers.split(delimiter);
    }

    private int sum(String[] numbers) {
        int total = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String number : numbers) {
            if (!number.trim().isEmpty()) {
                int num = parseNumber(number.trim());
                if (num < 0) {
                    negatives.add(num);
                } else {
                    total += num;
                }
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + negatives);
        }

        return total;
    }

    private int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자 형식입니다: " + number);
        }
    }
}