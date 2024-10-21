package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private final String INPUT;

    public Input() {
        INPUT = Console.readLine();
    }

    public String getInput() {
        return INPUT;
    }
}