package calculator.controller;

import calculator.model.StringExpression;
import calculator.model.SumResult;
import calculator.service.SumCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;
    private final SumCalculator sumCalculator;

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.sumCalculator = new SumCalculator();
    }

    public void run() {
        try {
            String input = inputView.readExpression();
            StringExpression expression = new StringExpression(input);
            SumResult result = sumCalculator.calculate(expression);
            outputView.printResult(result.getResult());
        } catch (IllegalArgumentException exception) {
            throw exception; //추후 수정 부분
        }
    }
}
