package calculator.domain;

import java.util.regex.Pattern;

public class Calculator {

    private static final String DEFAULT_DELIMITERS = ",|:";  // 기본 구분자

    // 입력 문자열을 받아 덧셈 결과를 반환
    public int calculate(String input) {
        if (input == null || input.trim().isEmpty()) {
                throw new IllegalArgumentException("유효하지 않은 숫자입니다: " + input);
        }

        String normalizedInput = normalizeInput(input);
        return add(normalizedInput);
    }

    // 커스텀 구분자를 쉼표(,) 구분자로 변환
    private String normalizeInput(String input) {
        input = input.replace("\\n", "\n");

        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf('\n');
            if (newlineIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
            }

            String delimiter = input.substring(2, newlineIndex);
            String content = input.substring(newlineIndex + 1);

            validateContent(content, delimiter);
            return content.replace(delimiter, ",");
        }

        validateContent(input, DEFAULT_DELIMITERS);
        return input;
    }

    // 구분자와 숫자 유효성 검사
    private void validateContent(String content, String delimiter) {
        if (content.contains(",,") || content.contains("::") || content.contains(delimiter + delimiter)) {
            throw new IllegalArgumentException("연속된 구분자는 허용되지 않습니다.");
        }

        if (content.endsWith(",") || content.endsWith(":") || content.endsWith(delimiter)) {
            throw new IllegalArgumentException("마지막에 구분자가 올 수 없습니다.");
        }

        String[] tokens = content.split(delimiter.equals(",|:") ? "[,:]" : Pattern.quote(delimiter));
        for (String token : tokens) {
            if (token.trim().isEmpty()) {
                throw new IllegalArgumentException("유효하지 않은 숫자입니다: 공백");
            }
            if (!isNumeric(token)) {
                throw new IllegalArgumentException("유효하지 않은 숫자입니다: " + token);
            }
            if (Integer.parseInt(token) < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + token);
            }
        }
    }

    // 문자열이 숫자인지 확인
    private boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c) && c != '-') {
                return false;
            }
        }
        return true;
    }

    // 문자열을 구분자 기준으로 나누고 합산
    private int add(String result) {
        String[] arr = result.split("[,:]");
        int sum = 0;

        for (String s : arr) {
            sum += parseNumber(s);
        }
        return sum;
    }

    // 문자열을 정수로 변환 (음수 예외 처리 포함)
    private int parseNumber(String s) {
        if (s == null || s.trim().isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 숫자입니다: " + s);
        }

        try {
            int num = Integer.parseInt(s.trim());
            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자입니다: " + s);
        }
    }
}
