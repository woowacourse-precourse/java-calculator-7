package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int result = calculateSum(input);
        System.out.println("결과 : " + result);
    }

    private static int calculateSum(String input) {
        if (input.isEmpty()) {
            return 0;  // 빈 문자열 처리
        }
        // 더미 메서드로 표현
        return 0;
    }

    private static String getDelimiter(String input) {
        // 더미 메서드로 표현
        return ",";
    }

    private static String getNumbersString(String input, String delimiter) {
        // 더미 메서드로 표현
        return "";
    }

    private static List<Integer> parseNumbers(String input, String delimiter) {
        // 더미 메서드로 표현
        return List.of();
    }

    private static int sumNumbers(List<Integer> numbers) {
        // 더미 메서드로 표현
        return 0;
    }

    private static int parseInt(String s) {
        // 더미 메서드로 표현
        return 0;
    }

    private static void validateNumber(String s) {
        // 더미 메서드로 표현
    }
}
