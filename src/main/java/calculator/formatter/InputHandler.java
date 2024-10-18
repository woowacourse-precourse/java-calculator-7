package calculator.formatter;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public static String input() {
        return Console.readLine();
    }

    public static void close() {
        Console.close();
    }
}
