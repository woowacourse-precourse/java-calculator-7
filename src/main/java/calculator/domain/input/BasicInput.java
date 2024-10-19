package calculator.domain.input;

import calculator.util.InputValidator;
import calculator.util.StringUtil;
import java.util.Arrays;

public class BasicInput extends Input {

    private static final String BASIC_DELIMITER = "[,:]";

    private BasicInput(String text) {
        super(text);
    }

    public static Input from(String text) {
        return new BasicInput(text);
    }

    @Override
    public Long[] createCalculationInputs() {
        return Arrays.stream(StringUtil.splitText(text, BASIC_DELIMITER))
                .map(InputValidator::validateOnlyPlainNumber)
                .peek(InputValidator::validatePositive)
                .toArray(Long[]::new);
    }

}
