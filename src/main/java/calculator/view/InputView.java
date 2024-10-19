package calculator.view;

import static calculator.util.Messages.INPUT_VALUE_START_MSG;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputValue() {
        System.out.println(INPUT_VALUE_START_MSG);
        return Console.readLine();
    }
}
