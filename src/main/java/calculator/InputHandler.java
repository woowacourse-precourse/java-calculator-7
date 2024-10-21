package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    String inputData;

    InputHandler() {

    }

    public void input() {
        inputData = Console.readLine();
    }

    public String getInputData() {
        return inputData;
    }

    public void setInputData(String inputData) {
        this.inputData = inputData;
    }
}
