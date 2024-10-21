package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        try {
            String input = Console.readLine();
            System.out.println("결과 : " + add(input));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = "[,|:]";
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");
            delimiter = input.substring(2, delimiterIndex);
            input = input.substring(delimiterIndex + 2);
        }

        String[] tokens = input.split(delimiter);
        return Arrays.stream(tokens)
                .mapToInt(Application::toPositiveInt)
                .sum();
    }

    private static int toPositiveInt(String value) {
        try {
            int number = Integer.parseInt(value);
            if (number < 0) {
                throw new IllegalArgumentException("Negative numbers are not allowed: " + value);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input: " + value);
        }
    }
}
