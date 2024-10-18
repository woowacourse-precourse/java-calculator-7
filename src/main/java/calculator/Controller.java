package calculator;

import calculator.view.OutputView;
import calculator.view.InputView;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;

    public Controller() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        String input = inputView.inputString();
    }

}
