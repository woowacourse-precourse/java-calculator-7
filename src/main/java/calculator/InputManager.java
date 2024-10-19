package calculator;

import static calculator.CustomPartManager.validateCustomPart;
import static calculator.SeparatorManager.initSeparator;
import static calculator.StringPartManager.initString;
import static calculator.StringPartManager.validateString;

public class InputManager {

    static Data validateInput(String input) {
        boolean hasCustomSeparator = validateCustomPart(input);
        String separators = initSeparator(input, hasCustomSeparator);
        String str = initString(input, hasCustomSeparator);
        validateString(str, separators);

        return new Data(separators, str);
    }
}
