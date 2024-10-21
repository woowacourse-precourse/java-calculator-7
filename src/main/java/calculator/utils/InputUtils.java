package calculator.utils;

import camp.nextstep.edu.missionutils.Console;

public class InputUtils {
    public static String getInput(String message) {
        String input;

        System.out.println(message);
        input = Console.readLine();

        return input;
    }
}
