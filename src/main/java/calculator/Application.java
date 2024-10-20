package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String RESULT_STATEMENT = "결과 : ";
    private static final String DEFAULT_REGEX = ",|:";
    private static final String CUSTOM_DELIMITER_FORMAT = "//#\\n";
    public static void main(String[] args) {
        String input = Console.readLine();

        if (input.isBlank()) {
            System.out.println(RESULT_STATEMENT + 0);
            return;
        }
        run(input);
    }

    private static void run(String input) {
        String regex = DEFAULT_REGEX;
        if (checkWhetherInputUsingCustomDelimiter(input)) {
            regex = regex + '|' + getCustomDelimiter(input);
            input = input.substring(5);
        }
        String[] splited = input.split(regex);
        System.out.println(RESULT_STATEMENT + calculate(splited));
    }

    private static boolean checkWhetherInputUsingCustomDelimiter(String input) {
        if (input.charAt(0) >= '0' && input.charAt(0) <= '9') {
            return false;
        } else if (input.charAt(0) == CUSTOM_DELIMITER_FORMAT.charAt(0)) {
            return true;
        }
        throw new IllegalArgumentException();
    }

    private static char getCustomDelimiter(String input) {
        if (input.length() < 5) {
            throw new IllegalArgumentException();
        }
        for (int i = 1; i <= 4; i++) {
            if (i == 1 && input.charAt(i) != CUSTOM_DELIMITER_FORMAT.charAt(1)) {
                throw new IllegalArgumentException();
            } else if (i == 3 && input.charAt(i) != CUSTOM_DELIMITER_FORMAT.charAt(3)) {
                throw new IllegalArgumentException();
            } else if (i == 4 && input.charAt(i) != CUSTOM_DELIMITER_FORMAT.charAt(4)) {
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