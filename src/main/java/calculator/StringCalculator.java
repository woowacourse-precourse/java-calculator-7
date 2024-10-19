package calculator;

import camp.nextstep.edu.missionutils.Console;

public class StringCalculator {

    public void run() {
        String input = inputString();
    }

    private String inputString() {
        String input = Console.readLine();
        return input;
    }
}
