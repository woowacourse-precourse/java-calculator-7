package calculator.domain;

import java.util.regex.Pattern;

public class Calculator {

    private static final String DEFAULT_DELIMITERS = ",|:";

    /**
     * 입력 문자열을 받아 결과를 반환.
     */
    public int add(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }

        String[] parts = extractCustomDelimiter(input);
        String delimiter = parts[0];
        String numbers = parts[1];

        validateContent(numbers, delimiter);
        String[] s = numbers.split(delimiter);
        return calculateSum(s);
    }

    /**
     * 입력 문자열에서 커스텀 구분자를 추출하고 반환.
     */
    private String[] extractCustomDelimiter(String input) {
        input = input.replace("\\n", "\n");
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf('\n');
            if (newlineIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다. \\n을 포함해야 합니다.");
            }
            String customDelimiter = input.substring(2, newlineIndex);
            if (customDelimiter.isEmpty()) {
                throw new IllegalArgumentException("커스텀 구분자는 최소 한 글자 이상이어야 합니다.");
            }
            String numbers = input.substring(newlineIndex + 1);
            if (numbers.isBlank()) {
                throw new IllegalArgumentException("숫자 부분이 공백일 수 없습니다.");
            }
            return new String[]{Pattern.quote(customDelimiter), numbers};
        }
        return new String[]{DEFAULT_DELIMITERS, input};
    }

    /**
     * 문자열에서 구분자 예외 처리
     */
    private void validateContent(String s, String delimiter) {
        if (s.endsWith(",") || s.endsWith(":") || s.endsWith(delimiter)) {
            throw new IllegalArgumentException("마지막에 구분자가 올 수 없습니다.");
        }
        if (s.contains(delimiter + delimiter)) { // 연속된 구분자 처리
            throw new IllegalArgumentException("연속된 구분자는 허용되지 않습니다.");
        }

        for (String num : s.split(delimiter)) {
            checkForInvalidNumber(num);
        }
    }

    /**
     * 구분자로 나눈 숫자 문자열의 합을 계산
     */
    private int calculateSum(String[] s) {
        int sum = 0;
        for (String content : s) {
            if (content.isEmpty()) {
                throw new IllegalArgumentException("연속된 구분자는 허용되지 않습니다.");
            }
            int number = parseNumber(content);
            sum += number;
        }
        return sum;
    }

    /**
     * 숫자 문자열의 유효성을 검사
     */
    /**
     * 숫자 문자열의 유효성을 검사
     */
    private void checkForInvalidNumber(String s) {
        int number = Integer.parseInt(s);
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
        }

        if (!s.matches("\\d+")) {
            throw new IllegalArgumentException("유효하지 않은 숫자입니다: " + s);
        }
    }

    /**
     * 문자열을 정수로 변환
     */
    private int parseNumber(String s) {
        return Integer.parseInt(s);
    }
}