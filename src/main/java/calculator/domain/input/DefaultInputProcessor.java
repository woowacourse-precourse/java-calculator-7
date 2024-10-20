package calculator.domain.input;

import calculator.domain.Separator;

public class DefaultInputProcessor implements InputProcessor {

    @Override
    public String[] processInput(String input, Separator separator) {
        separator.validateSeparators(input);
        return separator.splitCalculationString(input);
    }
}
