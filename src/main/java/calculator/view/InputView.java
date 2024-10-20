package calculator.view;

import camp.nextstep.edu.missionutils.Console;
import calculator.config.ViewConstants;

public class InputView {
    public String getInput() {
        System.out.println(ViewConstants.INPUT_PROMPT);
        return Console.readLine();
    }
}
