package calculator.view;

import calculator.domain.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final InputValidator inputValidator = new InputValidator();

    public String inputString() {
        String input = Console.readLine();
        validateInput(input);
        return input;
    }

    private void validateInput(String input) {
        inputValidator.validateFormat(input);
    }
}
