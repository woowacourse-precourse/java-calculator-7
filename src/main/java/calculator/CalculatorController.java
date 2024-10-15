package calculator;

import calculator.view.OutputView;

public class CalculatorController {

    private OutputView outputView;

    public CalculatorController() {
        this.outputView = new OutputView();
    }

    public void calculate() {
        outputView.printStartMessage();
    }
}
