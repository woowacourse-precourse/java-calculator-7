package calculator.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class Input {

    public static String readLine() {
        String inputString = "";
        try {
            inputString = Console.readLine();
        } catch (NoSuchElementException ignored) {
        }
        return inputString;
    }

}
