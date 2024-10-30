package calculator.input.strategy;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputStrategy implements InputStrategy {
    @Override
    public String input() {
        return Console.readLine();
    }
}
