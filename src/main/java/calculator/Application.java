package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();

        if (input.isBlank()) {
            System.out.println(0);
            return;
        }
        run(input);
    }

    private static void run(String input) {
        String regex = ",|:";
        if (checkWhetherInputUsingCustomDelimiter(input)) {
            regex = regex + '|' + getCustomDelimiter(input);
            input = input.substring(5, input.length() - 1);
        }
        String[] splited = input.split(regex);
        System.out.println(calculate(splited));
    }

    private static boolean checkWhetherInputUsingCustomDelimiter(String input) {
        if (input.charAt(0) >= '0' && input.charAt(0) <= '9') {
            return false;
        } else if (input.charAt(0) == '\\') {
            return true;
        }
        throw new IllegalArgumentException();
    }

    private static char getCustomDelimiter(String input) {
        for (int i = 1; i <= 4; i++) {
            if ((i == 1 || i == 3) && input.charAt(i) != '\\') {
                throw new IllegalArgumentException();
            } else if (i == 4 && input.charAt(i) != 'n') {
                throw new IllegalArgumentException();
            }
        }
        return input.charAt(2);
    }

    private static int calculate(String[] numbers) {
        int sum = 0;
        try {
            for (String number : numbers) {
                sum += Integer.parseInt(number);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return sum;
    }
}