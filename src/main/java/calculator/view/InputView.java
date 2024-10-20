package calculator.view;

import calculator.validation.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public InputView() {
    }

    public static String inputString() {
        String input = Console.readLine();
        if (input.isEmpty()) {
            return "0";
        }
        input = processInput(input);
        InputValidator.validateStartBlank(input);
        InputValidator.validateCustomSecond(input);
        InputValidator.validateCustomLength(input);
        InputValidator.validateNumberOnly(input);
        InputValidator.validateInvalidDelimiter(input);
        InputValidator.validateZero(input);
        InputValidator.validateMixedDelimiters(input);
        return input;
    }

    private static String processInput(String input) {
        return input.replace("\\n", "\n");
    }
}
