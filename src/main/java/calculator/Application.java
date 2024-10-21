package calculator;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        try {
            int result = addNumbers(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int addNumbers(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            delimiter = input.substring(2, delimiterEndIndex);
            input = input.substring(delimiterEndIndex + 1);
        }

        String[] tokens = input.split(delimiter);
        return Arrays.stream(tokens)
                     .mapToInt(token -> {
                         if (!token.matches("\\d+")) {
                             throw new IllegalArgumentException("잘못된 숫자: " + token);
                         }
                         return Integer.parseInt(token);
                     })
                     .sum();
    }
}

