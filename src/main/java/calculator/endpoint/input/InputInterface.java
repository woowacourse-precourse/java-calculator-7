package calculator.endpoint.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class InputInterface {
    public static String input(){
        try {
            return Console.readLine();
        } catch (NoSuchElementException|IllegalStateException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
