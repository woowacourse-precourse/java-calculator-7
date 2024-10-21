package calculator.domain.validator;

import static calculator.domain.CalculatorConstants.CUSTOM_DELIMITER_PREFIX;
import static calculator.domain.CalculatorConstants.CUSTOM_DELIMITER_SUFFIX;

public class InputValidator {

    public boolean isNegativeNumber(String input) {
        return input.contains("-");
    }

    public boolean containCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_DELIMITER_PREFIX.getValue())
                && input.contains(CUSTOM_DELIMITER_SUFFIX.getValue());
    }

    public boolean checkInputEmpty(String input) {
        return input == null || input.isEmpty();
    }

    public boolean isValidNumber(String str) {
        return str.matches("\\d+");
    }

}
