package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    int[] getInput() {
        String input = Console.readLine();

        StringParser parser = new StringParser();
        int[] numbers = parser.parseString(input);
        return numbers;
    }
}
