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
        // 구분자를 기준으로 문자열 분리
        return input.split(",|:");
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