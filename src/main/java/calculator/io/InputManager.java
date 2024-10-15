package calculator.io;

import calculator.domain.OriginalString;
import camp.nextstep.edu.missionutils.Console;

public class InputManager {

    private InputManager() { }

    public static OriginalString readInput() {
        String input = Console.readLine();
        return new OriginalString(input);
    }
}
