package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private String inputString = "";

    public InputView() {
        inputString = Console.readLine();
    }

    public String getInputString(){
        return this.inputString;
    }
}
