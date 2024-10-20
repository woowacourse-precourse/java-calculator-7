package calculator.view;

import static calculator.view.ViewMessage.NUMBERS_INPUT_MESSAGE;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public String numbersInputView() {
        System.out.println(NUMBERS_INPUT_MESSAGE.getMessage());
        return readLine();
    }
}
