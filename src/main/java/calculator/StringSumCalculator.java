package calculator;

import org.junit.platform.commons.util.StringUtils;

import java.util.regex.Pattern;

public class StringSumCalculator {
    private final InputValidator validator;

    public StringSumCalculator(InputValidator validator) {
        this.validator = validator;
    }

    public int add(String input) {
        if (StringUtils.isBlank(input)) {
            return 0;
        }

        String[] numbers = splitNumbers(input);

        int sum = 0;
        for (String number : numbers) {
            String trim = number.trim();
            validator.validateInput(trim);
            sum += validator.positiveNumber(Integer.parseInt(trim));
        }
        return sum;
    }

    private String[] splitNumbers(String input) {
        input = input.replace("\\n", "\n");

        if (!input.startsWith("//") || !input.contains("\n")) {
            return input.split(",|:");
        }

        int delimiterIdx = input.indexOf("\n");
        String customDelimiters = input.substring(2, delimiterIdx);
        String numbersWithDelimiter = input.substring(delimiterIdx + 1);

        if (!customDelimiters.startsWith("[") || !customDelimiters.endsWith("]")) {
            return numbersWithDelimiter.split(Pattern.quote(customDelimiters));
        } else {
            String[] delimiters = customDelimiters.substring(1, customDelimiters.length() - 1).split("]\\[");
            String delimiterPattern = String.join("|", Pattern.quote(delimiters[0]), Pattern.quote(delimiters[1]));
            return numbersWithDelimiter.split(delimiterPattern);
        }
    }

}