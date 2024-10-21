package calculator;

public class CalculatorController {

    CalculatorService calculatorService = new CalculatorService();

    public void run() {
        CalculatorView calculatorView = new CalculatorView();
        String userInputData = calculatorView.getUserInput();
        String customSeparator = calculatorService.checkCustomSeparator(userInputData);
    }
}

