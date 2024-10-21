package calculator.view;

import static calculator.common.Constants.INPUT_PROMPT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getInput () {
        System.out.println(INPUT_PROMPT);
        return Console.readLine();
    }
}
