package calculator.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    private final static InputConverter INPUT_CONVERTER = new InputConverter();

    public List<Integer> getInputFromUserForAddition() {
        String input = Console.readLine();
        return INPUT_CONVERTER.convert(input);
    }

}
