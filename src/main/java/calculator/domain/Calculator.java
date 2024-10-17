package calculator.domain;

import calculator.util.ValidationUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public int splitAndSum(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        List<String> delimiters = new ArrayList<>();
        delimiters.add(",");
        delimiters.add(":");

        delimiters.addAll(getCustomDelimiters(input));
        String numbers = removeCustomDelimiterPart(input, delimiters.size());

        String delimiterPattern = String.join("|", delimiters);
        return sumNumbers(numbers.split(delimiterPattern));
    }

    private List<String> getCustomDelimiters(String input) {
        List<String> delimiters = new ArrayList<>();
        Matcher matcher = Pattern.compile("//(.)\\n").matcher(input);

        while (matcher.find()) {
            String delimiter = matcher.group(1);
            ValidationUtils.validateCustomDelimiter(delimiter);
            delimiters.add(Pattern.quote(delimiter));
        }
        return delimiters;
    }

    private String removeCustomDelimiterPart(String input, int delimiterCount) {
        if (delimiterCount > 0) {
            int lastDelimiterIndex = input.lastIndexOf("\n");
            return input.substring(lastDelimiterIndex + 1);
        }
        return input;
    }

    private int sumNumbers(String[] numbers) {
        int sum = 0;
        List<Integer> parsedNumbers = new ArrayList<>();

        for (String number : numbers) {
            number = number.trim();

            if (!number.isEmpty()) {
                ValidationUtils.validateValidInteger(number);
                int parsedNumber = Integer.parseInt(number);
                parsedNumbers.add(parsedNumber);

                sum = safeSum(sum, parsedNumber);
            }
        }

        ValidationUtils.validateNumbers(parsedNumbers);
        return sum;
    }

    private int safeSum(int sum, int nextNumber) {
        try {
            return Math.addExact(sum, nextNumber);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("입력한 값의 계산 결과가 정수형 범위를 초과했습니다.");
        }
    }
}
