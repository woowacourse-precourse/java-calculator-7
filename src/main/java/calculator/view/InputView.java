package calculator.view;

import calculator.common.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputString() {
        String input = Console.readLine();

        validateInput(input);

        return input;
    }
    public static String getInput() {
        InputView inputView = new InputView();
        String input = inputView.inputString();
        validateInput(input);
        return input;
    }
    private static void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NULL_INPUT.getMessage());
        }
    }
}
