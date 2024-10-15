package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    public void turnOn() {
        String input = Console.readLine().trim();
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

}
