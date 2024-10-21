package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.CalculatorInputView;
import calculator.view.CalculatorOutputView;

public class CalculatorController {

    private final CalculatorInputView inputView = new CalculatorInputView();
    private final CalculatorOutputView outputView = new CalculatorOutputView();
    private final CalculatorService service = new CalculatorService();

    public void process() {
        outputView.init();
        int result = service.calculate(inputView.readLine());
        outputView.printResult(result);
    }
}
