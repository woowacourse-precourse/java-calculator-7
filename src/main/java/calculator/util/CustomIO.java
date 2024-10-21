package calculator.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class CustomIO {

    public static String readLine() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            return "";
        }
    }
}
