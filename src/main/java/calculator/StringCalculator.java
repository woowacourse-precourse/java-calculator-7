package calculator;

import java.util.Arrays;

public class StringCalculator {
    private final String str;

    public StringCalculator(String str) {
        this.str = str;
    }

    // 기본 구분자
    private String delimiter = ",|:";
    private final String specialDelimiter = ".*+?^${}()|[]\\";

    // 문자열을 정수로 변환하는 메서드
    private int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {   // 문자열을 정수로 전환할 수 없다면
            throw new IllegalArgumentException("Cannot change string to integer");
        }
    }

    // 음수를 체크하는 메서드
    private void checkNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Negative numbers are forbidden : " + number);
        }
    }

    //split 이후 빈 문자열이 있는지 체크하는 메서드
    private void checkNull(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Wrong usage of delimiter");
        }
    }

    //specialDelimiter가 존재하면 이스케이프 하는 메서드
    private String escapeSpecialDelimiter(String customDelimiter) {
        StringBuilder escapedDelimiter = new StringBuilder();
        for (char c : customDelimiter.toCharArray()) {
            if (specialDelimiter.indexOf(c) != -1) {
                escapedDelimiter.append("\\");
            }
            escapedDelimiter.append(c);
        }
        return escapedDelimiter.toString();
    }

    // 커스텀 구분자 처리 메서드
    private String extractNumbersWithCustomDelimiter() {
        int index = str.indexOf("\\n"); // '\'추가로 특수 문자 이스케이프
        if (index == -1) {
            throw new IllegalArgumentException("Missing \\n after custom delimiter");
        }

        // "//" 이후 "\n" 전까지가 커스텀 구분자
        String customDelimiter = str.substring(2, index);
        if (customDelimiter.isEmpty()) {
            throw new IllegalArgumentException("Custom delimiter cannot be empty");
        }
        // 기존 기본 구분자에 커스텀 구분자를 추가

        delimiter += "|" + escapeSpecialDelimiter(customDelimiter);

        // 커스텀 구분자 정의 부분 이후를 반환
        return str.substring(index + 2);
    }

    // 문자열을 더하는 메서드
    public int add() {
        String numbers = str;

        if (numbers == null || numbers.isEmpty()) { //입력값이 없다면 0을 리턴
            return 0;
        }

        if (numbers.startsWith("//")) {
            numbers = extractNumbersWithCustomDelimiter();
        }

        // limit:-1로 설정하면, 공백이어도 문자열의 끝까지 탐색해서 null로 저장한다.
        return Arrays.stream(numbers.split(delimiter, -1))
                .map(String::trim)  //공백 제거
                .peek(this::checkNull)
                .mapToInt(this::parseInt)
                .peek(this::checkNegative)
                .sum();
    }
}
