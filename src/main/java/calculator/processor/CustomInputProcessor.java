package calculator.domain.input;

import calculator.domain.Separator;
import calculator.validate.InputValidator;

public class CustomInputProcessor implements InputProcessor {

    private final InputValidator validator = new InputValidator();

    @Override
    public String[] processInput(String input, Separator separator) {
        validator.validateCustomInputFormat(input);
        String[] parts = input.split("\\\\n");
        String customSeparator = parts[0].substring(2);
        validator.validateCustomEmpty(customSeparator);
        validator.validateCustomSize(customSeparator);
        validator.validateNumberInCustom(customSeparator);

        separator.addCustomSeparator(customSeparator);
        return separator.splitCalculationString(parts[1]);
    }
}
