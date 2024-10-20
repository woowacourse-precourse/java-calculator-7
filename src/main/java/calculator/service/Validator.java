package calculator.service;

import calculator.model.UserInput;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//(.)\\\\n(.*)$");

    public void validateInput(UserInput input) {
        String inputString = input.getInputString();
        validateNullOrEmpty(inputString);

        if (hasCustomDelimiter(inputString)) {
            validateCustomDelimiterInput(inputString);
        } else {
            validateDefaultDelimiterInput(inputString);
        }
    }

    private void validateNullOrEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("값이 입력되지 않았습니다.");
        }
    }

    private boolean hasCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    private void validateCustomDelimiterInput(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            if (Character.isDigit(customDelimiter.charAt(0))) {
                throw new IllegalArgumentException("구분자로 숫자를 사용할 수 없습니다.");
            }
            String numbers = matcher.group(2);
            String allDelimiters = Pattern.quote(customDelimiter) + "|" + DEFAULT_DELIMITERS;
            validateNumbers(numbers, allDelimiters);
        } else {
            throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
        }
    }

    private void validateDefaultDelimiterInput(String input) {
        validateNumbers(input, DEFAULT_DELIMITERS);
    }

    private void validateNumbers(String input, String delimiters) {
        String[] numbers = input.split(delimiters, -1);  // -1 옵션을 사용하여 빈 문자열도 포함
        if (numbers.length == 0 || (numbers.length == 1 && numbers[0].isEmpty())) {
            throw new IllegalArgumentException("숫자가 입력되지 않았습니다.");
        }
        for (String number : numbers) {
            validateNumber(number.trim());
        }
    }

    private void validateNumber(String number) {
        if (number.isEmpty()) {
            throw new IllegalArgumentException("구분자의 앞 또는 뒤에 숫자가 입력되지 않았습니다.");
        }
        try {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new IllegalArgumentException("숫자는 양수만 입력할 수 있습니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다");
        }
    }
}
