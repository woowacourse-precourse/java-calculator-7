package calculator.domain;

import calculator.util.ValidationUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final String DEFAULT_DELIMITER_COMMA = ",";
    private static final String DEFAULT_DELIMITER_COLON = ":";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\\\\n";
    private static final int DEFAULT_DELIMITER_COUNT = 2;

    public int splitAndSum(String input) {
        if (isEmptyInput(input)) {
            return 0;
        }

        List<String> delimiters = buildDelimiters(input);
        String numbers = extractNumbers(input, delimiters.size());

        return sumNumbers(numbers.split(String.join("|", delimiters)));
    }

    private boolean isEmptyInput(String input) {
        return input == null || input.trim().isEmpty();
    }

    private List<String> buildDelimiters(String input) {
        List<String> delimiters = new ArrayList<>();
        delimiters.add(DEFAULT_DELIMITER_COMMA);
        delimiters.add(DEFAULT_DELIMITER_COLON);
        delimiters.addAll(getCustomDelimiters(input));
        return delimiters;
    }

    private List<String> getCustomDelimiters(String input) {
        List<String> delimiters = new ArrayList<>();
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);

        while (matcher.find()) {
            String delimiter = matcher.group(1);
            ValidationUtils.validateCustomDelimiter(delimiter);
            delimiters.add(Pattern.quote(delimiter));
        }
        return delimiters;
    }

    private String extractNumbers(String input, int delimiterCount) {
        if (delimiterCount > DEFAULT_DELIMITER_COUNT) {
            int lastDelimiterIndex = input.lastIndexOf("\\n");
            return input.substring(lastDelimiterIndex + 2);
        }
        return input;
    }

    private int sumNumbers(String[] numbers) {
        int sum = 0;
        List<Integer> parsedNumbers = new ArrayList<>();

        for (String number : numbers) {
            if (!number.trim().isEmpty()) {
                int parsedNumber = parseAndValidateNumber(number);
                parsedNumbers.add(parsedNumber);
                sum = safeSum(sum, parsedNumber);
            }
        }

        ValidationUtils.validatePositiveNumbers(parsedNumbers);
        return sum;
    }

    private int parseAndValidateNumber(String number) {
        ValidationUtils.validateValidInteger(number);
        return Integer.parseInt(number);
    }

    private int safeSum(int sum, int nextNumber) {
        try {
            return Math.addExact(sum, nextNumber);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("입력한 값의 계산 결과가 정수 범위를 초과했습니다.");
        }
    }
}
