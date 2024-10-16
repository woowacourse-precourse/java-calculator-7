package calculator.io;

import camp.nextstep.edu.missionutils.Console;

public class InputReader {

    private final String input;

    public InputReader() {
        this.input = Console.readLine();
    }

    public String getInput() {
        return this.input;
    }

}
