package calculator.domain.input;

import calculator.util.InputValidator;

public class OtherInput extends Input {

    private OtherInput(String text) {
        super(text);
    }

    public static Input from(String text) {
        return new OtherInput(text);
    }

    @Override
    public Long[] createCalculationInputs() {
        Long number = InputValidator.validateOnlyPlainNumber(text);
        InputValidator.validatePositive(number);

        return new Long[]{number};
    }

}
