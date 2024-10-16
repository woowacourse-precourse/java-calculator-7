package calculator.domain;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public int splitAndSum(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        Optional<String> customDelimiter = getCustomDelimiter(input);
        String numbers = removeCustomDelimiterPart(input, customDelimiter.isPresent());

        if (customDelimiter.isEmpty()) {
            return sumNumbers(numbers.split(",|:"));
        }

        return sumNumbers(numbers.split(customDelimiter.get() + "|,|:"));
    }

    private Optional<String> getCustomDelimiter(String input) {
        Matcher matcher = Pattern.compile("//(.)\\n").matcher(input);

        if (matcher.find()) {
            String delimiter = matcher.group(1);
            return Optional.of(Pattern.quote(delimiter));
        }

        return Optional.empty();
    }

    private String removeCustomDelimiterPart(String input, boolean hasCustomDelimiter) {
        if (hasCustomDelimiter) {
            return input.substring(input.indexOf("\n") + 1);
        }
        return input;
    }

    private int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number.trim());
        }
        return sum;
    }
}
