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
        checkPlainNumberAndPositive();

        return new Long[]{textToLong()};
    }

    private void checkPlainNumberAndPositive() {
        InputValidator.validatePositive(
                InputValidator.validateOnlyPlainNumber(text)
        );
    }

    private Long textToLong() {
        return Long.valueOf(text);
    }

}
