package calculator.view;

import calculator.enums.UIMessages;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String readInput() {
        System.out.println(UIMessages.INPUT_REQUEST.getMessage());
        return Console.readLine();
    }
}
