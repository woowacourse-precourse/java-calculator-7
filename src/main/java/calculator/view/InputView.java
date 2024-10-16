package calculator.view;

import calculator.enums.ViewMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String promptString() {
        System.out.println(ViewMessage.PROMPT_STRING.getMessage());
        System.out.println(ViewMessage.PROMPT_HINT.getMessage());
        return Console.readLine();
    }
}
