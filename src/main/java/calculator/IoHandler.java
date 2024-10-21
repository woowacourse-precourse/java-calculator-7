package calculator;

import camp.nextstep.edu.missionutils.Console;

public class IoHandler {

    public static String getUserInput() {
        return Console.readLine();
    }

    public static <T> void print(T obj) {
        System.out.print(String.valueOf(obj));
    }
}
