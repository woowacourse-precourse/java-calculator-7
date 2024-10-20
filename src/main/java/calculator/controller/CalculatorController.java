package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.CalculatorView;

public class CalculatorController {

    CalculatorService calculatorService;
    CalculatorView calculatorView;

    private CalculatorController() {
        calculatorService = CalculatorService.getInstance();
        calculatorView = CalculatorView.getInstance();
    }

    private static class SingletonHelper {
        private static final CalculatorController INSTANCE = new CalculatorController();
    }

    static public CalculatorController getInstance() {
        return SingletonHelper.INSTANCE;
    }


    public void start() {
        calculatorView.describe();

        mainFunction();
    }

    private void mainFunction() {

        String text = calculatorView.inputText();
        String targetText = calculatorService.findSeparator(text);

        try {
            int answer = calculatorService.calculate(targetText);
            calculatorView.outputAnswer(answer);

        } catch (IllegalArgumentException e) {
            calculatorView.error(e.getMessage());
        }
    }
}
