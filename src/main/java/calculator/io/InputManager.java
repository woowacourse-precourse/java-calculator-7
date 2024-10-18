package calculator.io;

import static calculator.util.Const.START_MESSAGE;

import calculator.domain.OriginalString;
import camp.nextstep.edu.missionutils.Console;

public class InputManager {

    private InputManager() { }

    public static OriginalString readInput() {
        System.out.println(START_MESSAGE);
        String input = Console.readLine();
        return new OriginalString(input);
    }
}
