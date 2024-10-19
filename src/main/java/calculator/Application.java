package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 입력 받기
        String input = Console.readLine();
    }

    // 주어진 구분자를 사용해 문자열을 숫자로 분리하고 합을 구하는 메서드
    private int sum(String input, String delimiter) {
        String[] tokens = input.split(delimiter); // 구분자로 숫자 분리
        int result = 0;
        for (String token : tokens) {
            int number = toPositiveInt(token);
            result += number;
        }
        return result;
    }

    // 문자열을 정수로 변환하며 음수를 체크하는 메서드
    private static int toPositiveInt(String value) {
        int number;
        try {
            number = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자 입력: " + value);
        }

        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + value);
        }
        return number;
    }
}
