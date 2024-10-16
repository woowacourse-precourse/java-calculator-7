package calculator.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private OutputView outputView = new OutputView();

    public String input() {
        return readLine();
    }

    public String input(String message) {
        outputView.printMessage(message);
        return input();
    }
}
