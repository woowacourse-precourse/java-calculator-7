package calculator.view;

import static calculator.view.constants.ViewMessage.INPUT_VIEW_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String print() {
        System.out.println(INPUT_VIEW_MESSAGE.getMessage());
        return Console.readLine();
    }
}
