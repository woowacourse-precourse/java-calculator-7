package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

    }

    private static boolean isDelimiterFormatCorrect(String[] parts) {
        return parts.length < 2 || parts[0].length() < 3; // 유효하지 않은 경우 true 반환
    }

    private static int sumNumbers(String numbers, String delimiter) {
        try {
            String[] tokens = numbers.split(delimiter);
            int sum = 0;

            for (String token : tokens) {
                if (!token.isEmpty()) {
                    int number = parseIntOrThrow(token.trim());
                    if (number < 0) {
                        throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + number);
                    }
                    sum += number;
                }
            }
            return sum; // 최종 합산 결과 반환
        } catch (IllegalArgumentException e) {
            throw e; // 예외를 상위로 던짐
        }
    }

    private static int parseIntOrThrow(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 형식입니다: " + value); // 잘못된 형식 처리
        }
    }
}
