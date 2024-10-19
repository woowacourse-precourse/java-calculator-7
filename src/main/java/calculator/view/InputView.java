package calculator.view;

import calculator.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public String inputStringToCalculate() {
        String input = Console.readLine();
        inputValidator.validate(input);
        return input;
    }
}
