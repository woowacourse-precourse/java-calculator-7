package calculator.view;

import calculator.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {
    }

    public static String inputCalculationString() {
        String input = Console.readLine();
        InputValidator.validate(input);
        return input;
    }
}
