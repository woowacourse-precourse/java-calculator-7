package calculator;

import calculator.exception.InvalidInputException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    public int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;  // 빈 문자열 또는 null은 0을 반환
        }

        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
        String delimiter = DEFAULT_DELIMITERS;
        String numbers = input;

        if (matcher.matches()) {
            delimiter = matcher.group(1);
            numbers = matcher.group(2);
        }

        return sum(numbers, delimiter);
    }

    private int sum(String numbers, String delimiter) {
        String[] tokens = numbers.split(delimiter + "|" + DEFAULT_DELIMITERS);  // 커스텀 구분자와 기본 구분자를 모두 사용
        int sum = 0;

        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;  // 빈 문자열은 무시
            }
            int number = parseNumber(token);
            validateNonNegative(number);
            sum += number;
        }

        return sum;
    }

    private int parseNumber(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("잘못된 입력입니다.");  // 숫자가 아닌 경우 예외 발생
        }
    }

    private void validateNonNegative(int number) {
        if (number < 0) {
            throw new InvalidInputException("음수는 허용되지 않습니다.");  // 음수 입력 시 예외 발생
        }
    }
}