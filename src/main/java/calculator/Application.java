package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String delimiter = getDelimiter(input);  // 구분자 결정
        // 더미 메서드로 표현
        return 0;
    }

    private static String getDelimiter(String input) {
        if (input.startsWith("//")) {
            return extractCustomDelimiter(input);  // 커스텀 구분자 추출
        }
        return ",|:";  // 기본 구분자
    }

    private static String extractCustomDelimiter(String input) {
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
