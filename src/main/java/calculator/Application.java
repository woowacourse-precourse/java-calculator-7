package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();
        System.out.println("결과 : " + calculate(input));
    }

    private static int calculate(String input) {
        if (input.startsWith("//")) {
            String[] parts = input.split("\\\\n", 2);
            String customDelimiter = parts[0].substring(2);
            String numbers = parts[1];

            return sum(numbers.split(customDelimiter));
        } else {
            return sum(input.split(","));
        }
    }

    private static int sum(String[] numbers) {
        int result = 0;
        for (String number : numbers) {
            int num = Integer.parseInt(number.trim());
            if (num < 0) {
                throw new IllegalArgumentException();
            }
            result += num;
        }
        return result;
    }
}
