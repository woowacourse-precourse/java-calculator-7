package calculator.view;

import calculator.validator.BasicValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final BasicValidator<String> inputValidator;

    public InputView(BasicValidator<String> inputValidator) {
        this.inputValidator = inputValidator;
    }

    public String inputStringToCalculate() {
        String input = Console.readLine();
        inputValidator.validate(input);
        return input;
    }
}
