package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();
            int result = Calculator.add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

class Calculator {
    public static int add(String input) {
        String[] tokens = tokenize(input);
        return sum(tokens);
    }

    private static String[] tokenize(String input) {
        String customDelimiter = ",|:";  // 기본 구분자

        // 커스텀 구분자가 있을 경우 처리
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("잘못된 형식입니다. 커스텀 구분자 뒤에 줄바꿈이 있어야 합니다.");
            }
            customDelimiter = input.substring(2, delimiterEndIndex);
            input = input.substring(delimiterEndIndex + 2);
        }

        // 구분자를 기준으로 문자열 분리
        return input.split(customDelimiter);
    }

    private static int sum(String[] tokens) {
        int total = 0;
        for (String token : tokens) {
            int number = Integer.parseInt(token);
            total += number;
        }
        return total;
    }
}