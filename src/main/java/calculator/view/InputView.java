package calculator.view;

import calculator.global.exception.CalculatorException;
import calculator.view.constant.errorMessage.InputErrorMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputString() {
        String input = Console.readLine();
        validateInput(input);
        return input;
    }

    private void validateInput(String input) {
        if (input.isEmpty()) {
            throw new CalculatorException(InputErrorMessage.NULL_INPUT_ERROR);
        }
    }
}
