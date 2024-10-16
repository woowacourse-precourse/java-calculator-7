package calculator.view;

import camp.nextstep.edu.missionutils.Console;

import static calculator.view.ViewMessages.INPUT_MESSAGE;
public class InputView {
    public InputView() {
    }

    public String getInput() {
        System.out.println(INPUT_MESSAGE);
        return Console.readLine();
    }
}
