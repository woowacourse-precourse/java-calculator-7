package calculator;

import java.util.Arrays;

public class StringCalculator {
    private final String str;

    public StringCalculator(String str) {
        this.str = str;
    }

    // 기본 구분자
    private String delimiter = ",:";

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

    // 문자열을 더하는 메서드
    public int add() {
        String numbers = str;

        if (numbers == null || numbers.isEmpty()) { //입력값이 없다면 0을 리턴
            return 0;
        }

        return Arrays.stream(numbers.split("[" + delimiter + "]", -1))
                //limit:-1로 설정하면, 공백이어도 문자열의 끝까지 탐색해서 null로 저장한다.
                .map(String::trim)
                .mapToInt(this::parseInt)
                .peek(this::checkNegative)
                .sum();
    }
}
