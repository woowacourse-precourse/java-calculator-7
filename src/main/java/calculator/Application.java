package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Application {
    private static String input;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 사용자로부터 입력을 받는다.
        String input = getInput();
        int result = add(input);
        System.out.println("결과: " + result);
    }

    private static String getInput() {
        // 사용자 입력 받는 코드 (예: Scanner 사용)
        return "//;\n1;2;3"; // 테스트를 위한 임시 입력
    }

    public static int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n"; // 기본 구분자
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            delimiter = Pattern.quote(input.substring(2, delimiterEndIndex).trim());
            input = input.substring(delimiterEndIndex + 1);
        }

        String[] numbers = input.split(delimiter);
        return sum(numbers);
    }

    private static int sum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            if (!number.isEmpty()) {
                int num = Integer.parseInt(number.trim());
                if (num < 0) {
                    throw new IllegalArgumentException("음수를 입력할 수 없습니다.");
                }
                sum += num;
            }
        }
        return sum;
    }
}