package calculator.view;

import calculator.domain.validator.DelimiterValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final DelimiterValidator delimiterValidator = new DelimiterValidator();

    public String inputString() {
        String input = Console.readLine();
        validateInput(input);
        return input;
    }

    private void validateInput(String input) {
        delimiterValidator.validateFormat(input);
    }
}
