package calculator.view;

import calculator.common.ErrorMessage;
import calculator.exception.CalculatorException;
import calculator.model.validator.NegativeNumberValidator;
import calculator.model.validator.NumberRangeValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final NegativeNumberValidator negativeNumberValidator = new NegativeNumberValidator();
    private final NumberRangeValidator numberRangeValidator = new NumberRangeValidator();
    public String inputString() {
        String input = Console.readLine();

        validateInput(input);

        return input;
    }
    private void validateInput(String input) {
        if (input.isEmpty()) {
            throw new CalculatorException(ErrorMessage.NULL_INPUT);
        }
        int number = Integer.parseInt(input);
        negativeNumberValidator.validate(number);
        numberRangeValidator.validate(number);
    }
}
