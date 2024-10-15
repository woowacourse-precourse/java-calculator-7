package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();

        if (input.isBlank()) {
            System.out.println(0);
            return;
        }
    }

    private static boolean checkWhetherInputUsingCustomDelimiter(String input) {
        if (input.charAt(0) >= '0' && input.charAt(0) <= '9') {
            return false;
        } else if (input.charAt(0) == '\\') {
            return true;
        }
        throw new IllegalArgumentException();
    }
}