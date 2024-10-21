package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    String inputData;
    private static InputHandler instance;

    private InputHandler() {

    }

    public static InputHandler getInstance() {
        if (instance == null) {
            instance = new InputHandler();
        }
        return instance;
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
