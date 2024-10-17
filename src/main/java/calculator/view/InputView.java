package calculator.view;

import calculator.validation.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public InputView() {
    }

    public static String inputString() {
        String input = Console.readLine();
        InputValidator.validateStartBlank(input);
        InputValidator.validateCustomSecond(input);
        InputValidator.validateCustomLength(input);
        InputValidator.validateNumberOnly(input);
        InputValidator.validateInvalidDelimiter(input);
        InputValidator.validateZero(input);
        InputValidator.validateMixedDelimiters(input);
        return input;
    }
}
