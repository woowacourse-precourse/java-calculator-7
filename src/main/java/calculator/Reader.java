package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Reader {
    public static void readString() {
        try {
            Application.setInput(Console.readLine());
        } catch (java.util.NoSuchElementException e) {
            Application.setInput("");
        }
    }
}
