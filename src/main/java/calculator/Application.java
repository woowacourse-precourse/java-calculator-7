package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();
            int result = StringCalculator.calculate(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }


    private static class StringCalculator {
        public static int calculate(String input) {
            if (input == null || input.isEmpty()) {
                return 0;
            }

            String delimiter = ",|:"; // 기본 구분자
            String numbers = input;

            if (input.startsWith("//")) {
                int delimiterEndIndex = input.indexOf("\\n");
                if (delimiterEndIndex == -1) {
                    throw new IllegalArgumentException("잘못된 입력입니다: 커스텀 구분자 지정 후 개행문자가 필요합니다.");
                }
                String customDelimiter = input.substring(2, delimiterEndIndex);
                delimiter = Pattern.quote(customDelimiter);
                numbers = input.substring(delimiterEndIndex + 2);
            }

            String[] tokens = numbers.split(delimiter);
            int sum = 0;

            for (String token : tokens) {
                if (token.isEmpty()) {
                    continue;
                }
                try {
                    int number = Integer.parseInt(token);
                    if (number <= 0) {
                        throw new IllegalArgumentException("잘못된 입력입니다: 양의 정수만 허용됩니다.");
                    }
                    sum += number;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("잘못된 입력입니다: 숫자가 아닌 값이 포함되어 있습니다.");
                }
            }

            return sum;
        }
    }
}
// "//;\n1;2;3"
