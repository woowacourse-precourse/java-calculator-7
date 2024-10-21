package calculator.controller;

import calculator.model.CalculatorModel;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final CalculatorModel model;
    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController() {
        this.model = new CalculatorModel();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        String formula = inputView.input();
        boolean isCustom = model.checkCustomDelimiter(formula);
        String[] delimiterAndNumbers = model.validateDelimiter(isCustom, formula);
        int result = model.sum(delimiterAndNumbers[0], delimiterAndNumbers[1]);
        outputView.output(result);
    }

}
