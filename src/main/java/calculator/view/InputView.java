package calculator.view;

import calculator.dto.AdditionInput;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {
    }

    public static AdditionInput readAdditionInput() {
        String input = Console.readLine();
        return new AdditionInput(input.trim());
    }
}