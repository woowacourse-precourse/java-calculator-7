package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Io {

    public static String input() {
        String inputValue = Console.readLine();
        Console.close();

        return inputValue;
    }

    public static void print(String message) {
        System.out.println(message);

    }
}
