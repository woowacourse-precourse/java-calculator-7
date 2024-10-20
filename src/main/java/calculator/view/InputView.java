package calculator.view;

import calculator.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final InputValidator inputValidator = new InputValidator();
    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public String readString() {
        System.out.println(INPUT_MESSAGE);
        String inputString = Console.readLine();
        if (isBlank(inputString)) {
            return inputString;
        }
        inputValidator.isValidInput(inputString);
        return inputString;
    }

    private boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }
}
