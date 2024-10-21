package calculator;

import view.InputView;
import view.OutputView;

public class CalculatorController {
    private final Calculator calculator;
    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController() {
        this.calculator = new Calculator();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        String formula = inputView.input();
        boolean isCustom = calculator.checkCustomDelimiter(formula);
        String[] delimiterAndNumbers = calculator.validateDelimiter(isCustom, formula);
        int result = calculator.sum(delimiterAndNumbers[0], delimiterAndNumbers[1]);
        outputView.output(result);
    }

}
