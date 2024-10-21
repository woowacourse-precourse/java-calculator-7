package calculator.views;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static InputView instance;

    private InputView() {
    }

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }

    public String getInputFromUser() {
        String input = Console.readLine();
        Console.close();

        return input;
    }
}
