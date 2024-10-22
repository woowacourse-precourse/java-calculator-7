package calculator.view;

import calculator.common.ErrorMessage;
import calculator.exception.CalculatorException;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputString() {
        String input = Console.readLine();

        validateInput(input);

        return input;
    }
    private void validateInput(String input) {
        if (input.isEmpty()) {
            throw new CalculatorException(ErrorMessage.NULL_INPUT);
        }
    }
}
