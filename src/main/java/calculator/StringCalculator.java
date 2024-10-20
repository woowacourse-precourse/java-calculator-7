package calculator;

import calculator.exception.InvalidInputException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    public int calculate(String input) {
        if (input == null || input.isEmpty()) {
            throw new InvalidInputException("입력값이 없습니다.");  // 빈 문자열 예외 처리
        }

        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
        String delimiter = DEFAULT_DELIMITERS;
        String numbers = input;

        // 커스텀 구분자 패턴이 매칭되면
        if (matcher.matches()) {
            delimiter = matcher.group(1);
            numbers = matcher.group(2);
            // 구분자 뒤에 숫자가 없을 경우 예외 발생
            if (numbers == null || numbers.isEmpty() || numbers.trim().isEmpty()) {
                throw new InvalidInputException("잘못된 입력입니다.");  // 구분자가 없거나 잘못된 경우
            }
            // 구분자가 유효한지 검사 (여기서 세미콜론을 허용하지 않도록 추가)
            if (delimiter == null || delimiter.trim().isEmpty()) {
                throw new InvalidInputException("잘못된 입력입니다.");  // 구분자가 없거나 잘못된 경우
            }
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
            int number = Integer.parseInt(token);
            if (number == 0) {
                throw new InvalidInputException("0은 허용되지 않습니다.");  // 0 예외 처리
            }
            return number;
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
