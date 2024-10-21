package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static final String DEFAULT_DELIMITERS = "[,:]"; // 기본 구분자
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)"; // 커스텀 구분자 정규 표현식

    public int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0; // 입력이 비어있으면 0을 반환
        }

        String[] parts = extractDelimiters(input); // 구분자 및 숫자 문자열 분리
        String delimiter = parts[0]; // 구분자
        String numbers = parts[1]; // 숫자 문자열

        return sumNumbers(numbers.split(delimiter)); // 합계를 계산하여 반환
    }

    private String[] extractDelimiters(String input) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1); // 커스텀 구분자
            String numbers = matcher.group(2); // 숫자 문자열
            // 커스텀 구분자와 기본 구분자를 함께 사용 가능하도록 처리
            String combinedDelimiters = DEFAULT_DELIMITERS + "|" + Pattern.quote(customDelimiter);
            return new String[]{combinedDelimiters, numbers};
        }
        return new String[]{DEFAULT_DELIMITERS, input}; // 기본 구분자만 반환
    }

    private int sumNumbers(String[] numbers) {
        int sum = 0; // 합계 초기화
        for (String number : numbers) {
            if (!number.isEmpty()) { // 빈 문자열은 무시
                validateNumber(number); // 숫자 유효성 검사
                sum += Integer.parseInt(number); // 문자열을 정수로 변환하여 합산
            }
        }
        return sum; // 합계 반환
    }

    private void validateNumber(String number) {
        try {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number); // 음수가 발견되면 예외 발생
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자: " + number); // 숫자가 아닌 경우 예외 발생
        }
    }
}
