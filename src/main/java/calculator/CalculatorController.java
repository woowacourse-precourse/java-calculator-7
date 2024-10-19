package calculator;

public class CalculatorController {

    private final CalculatorService calculatorService = new CalculatorService();
    private final CalculatorView calculatorView = new CalculatorView();

    public void startCalculate() {
        calculatorView.inputView();

        String input = calculatorService.getInput();
        int result = calculatorService.calculate(input);

        calculatorView.outputView(result);
    }
}
