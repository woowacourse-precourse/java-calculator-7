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
            System.out.println("잘못된 입력 : " + e.getMessage());
            throw e;
        }
    }
}

class Calculator {

    private static final String DEFAULT_DELIMITERS = ",|:";

    public static int add(String input) {
        if (input == null) {
            return 0;
        }

        String[] tokens;
        if (isCustom(input)) {
            tokens = splitCustom(input);
        } else {
            tokens = splitDefault(input);
        }

        return sum(tokens);
    }

    private static boolean isCustom(String input) {
        return input.startsWith("//");
    }

    private static String[] splitCustom(String input) {
        String customDelimiter = input.substring(2,3);
        String numPart = input.substring(5);
        return numPart.split(customDelimiter);
    }

    private static String[] splitDefault(String input) {
        return input.split(DEFAULT_DELIMITERS);
    }

    private static int sum(String[] tokens) {
        int total = 0;
        for (String token : tokens) {
            int number = parse(token);
            total += number;
        }
        return total;
    }

    private static int parse(String token) {
        int number = Integer.parseInt(token.trim());
        if (number < 0) {
            throw new IllegalArgumentException("음수는 입력 불가능합니다 : " + number);
        }
        return number;
    }
}
