package calculator.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import calculator.util.Util;

public class InputView {

    private OutputView outputView = new OutputView();

    public String input() {
        return readLine();
    }

    public String input(String message) {
        outputView.printMessage(message);
        return input();
    }

    public String newlineInput(String message) {
        outputView.printMessage(message);
        return Util.newlineConverter(input());
    }
}
