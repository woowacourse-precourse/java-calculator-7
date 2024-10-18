package calculator.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    // 기본 구분자 선언
    private static final String DEFAULT_DELIMITERS = ",|:";

    public static void validate(String userInput) {
        checkNullOrEmpty(userInput);
        checkNegativeNumbers(userInput);

        if (userInput.startsWith("//")) {
            validateCustomDelimiter(userInput);
        } else {
            validateNumbers(userInput, DEFAULT_DELIMITERS);
        }
    }

    // 입력이 null이거나 빈 문자열인지 확인하는 메서드
    private static void checkNullOrEmpty(String userInput) {
        if (userInput == null || userInput.trim().isEmpty()) {
            throw new IllegalArgumentException("입력 문자열이 null이거나 빈 문자열입니다.");
        }
    }

    // 음수가 포함되었는지 확인하는 메서드
    private static void checkNegativeNumbers(String userInput) {
        if (userInput.matches(".*-\\d+.*")) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }
    }

    // 커스텀 구분자가 올바르게 지정되었는지 확인하는 메서드
    private static void validateCustomDelimiter(String userInput) {
        Pattern customDelimiterPattern = Pattern.compile("//(.)\n(.*)");
        Matcher matcher = customDelimiterPattern.matcher(userInput);

        if (matcher.matches()) {
            String customDelimiter = matcher.group(1);
            String numbers = matcher.group(2);

            // 커스텀 구분자를 기본 구분자에 추가하여 유효성 검사
            String delimiters = DEFAULT_DELIMITERS + "|" + Pattern.quote(customDelimiter);
            validateNumbers(numbers, delimiters);
        } else {
            throw new IllegalArgumentException("올바르지 않은 커스텀 구분자 형식입니다.");
        }
    }

    // 숫자와 구분자를 이용해 입력이 올바른지 확인하는 메서드
    private static void validateNumbers(String numbers, String delimiters) {
        String[] tokens = numbers.split(delimiters);
        for (String token : tokens) {
            if (!token.matches("\\d+")) {
                throw new IllegalArgumentException("구분자 및 숫자 이외의 문자가 포함되어 있습니다.");
            }
        }
    }
}