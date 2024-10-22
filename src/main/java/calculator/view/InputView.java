package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readInput() {
        return readInputStringByConsoleApi();
    }

    private String readInputStringByConsoleApi() {
        return Console.readLine();
    }
}
