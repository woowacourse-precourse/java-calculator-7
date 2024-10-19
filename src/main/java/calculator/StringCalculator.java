package calculator;

import camp.nextstep.edu.missionutils.Console;

public class StringCalculator {
    private String userInput;

    public void run() {
        userInput = getUserInput();
    }

    private String getUserInput() {
        return Console.readLine();
    }
}
