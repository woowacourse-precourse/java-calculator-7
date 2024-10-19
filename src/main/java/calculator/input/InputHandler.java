package calculator.input;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    private static final InputHandler INSTANCE = new InputHandler();

    private InputHandler() {}

    public static InputHandler getInstance() {
        return INSTANCE;
    }

    public String getInput() {
        System.out.println("문자열을 입력해주세요");
        return Console.readLine();
    }

    public void closeInput() {
        Console.close();
    }
}
