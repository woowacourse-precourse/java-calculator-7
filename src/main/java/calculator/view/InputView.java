package calculator.view;

import calculator.constant.Prompt;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String input() {
        System.out.println(Prompt.PROMPT_INPUT.getText());
        return Console.readLine();
    }
}
