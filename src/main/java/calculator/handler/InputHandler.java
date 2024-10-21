package calculator.handler;

import calculator.parser.StringParser;
import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public int[] getInput() {
        String input = Console.readLine();

        StringParser parser = new StringParser();
        int[] numbers = parser.parseString(input);
        return numbers;
    }
}
