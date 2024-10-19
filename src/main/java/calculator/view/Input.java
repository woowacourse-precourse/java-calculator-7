package calculator.view;

import calculator.exception.CalculatorException;
import camp.nextstep.edu.missionutils.Console;

public class Input {

    public String getInput() {
        String input = Console.readLine();
        validateInput(input);
        return input;
    }

    private String validateInput(String input) {

        if (isNull(input) || isInputBlank(input)) {
            CalculatorException.causeException("띄어쓰기를 포함시킬 수 없습니다.");
        }

        return input;
    }

    private boolean isInputBlank(String input) {
        return input != null && !input.equals(" ");
    }

    private boolean isNull(String input) {
        return input == null;
    }

}
