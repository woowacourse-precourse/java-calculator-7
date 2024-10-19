package calculator.controller;


import calculator.model.CalculatorService;
import calculator.model.ValidationUtils;
import calculator.view.InputView;
import calculator.view.OutputView;


public class CalculatorController {
    private final InputView inputview = new InputView();
    private final ValidationUtils validationUtils = new ValidationUtils();
    private final CalculatorService calculatorService = new CalculatorService();
    private final OutputView outputView = new OutputView();

    public void run() {
        try {
            String input = inputview.input();
            validationUtils.validateInput(input);
            int result = calculatorService.calculate(input);
            outputView.output(result);

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
