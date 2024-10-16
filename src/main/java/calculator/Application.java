package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();
        System.out.println(hasCustomDelimiter(input));
    }

    static boolean hasCustomDelimiter(String input) {
        return input.startsWith("//");
    }
}
