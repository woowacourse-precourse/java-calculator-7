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
        InputValidator.validatePositive(
                InputValidator.validateOnlyPlainNumber(text)
        );

        return new Long[]{toLong(text)};
    }

    private Long toLong(String text) {
        return Long.valueOf(text);
    }

}
