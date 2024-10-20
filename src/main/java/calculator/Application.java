package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int result = add(input);
        System.out.println("결과 : " + result);
    }

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] numbers = splitInput(input);
        return sumNumbers(numbers);
    }

    private static String[] splitInput(String input) {
        // 쉼표(,)와 콜론(:)을 기본 구분자로 처리
        String delimiter = ",|:";
        return input.split(delimiter);
    }

    private static int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += parseNumber(number);
        }
        return sum;
    }

    private static int parseNumber(String number) {
        return Integer.parseInt(number);
    }
}