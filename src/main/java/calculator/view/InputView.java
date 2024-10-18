package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String startInputValue() {
        String input = Console.readLine();
        if (input.isBlank()) {
            return "0";
        }
        return input;
    }
}
