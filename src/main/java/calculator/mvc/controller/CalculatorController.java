package calculator.mvc.controller;

import calculator.mvc.model.calculator.Calculator;
import calculator.mvc.model.calculator.CalculatorImpl;
import calculator.mvc.model.expression.CustomExpression;
import calculator.mvc.view.CalculatorView;

public class CalculatorController {
    private Calculator model;
    private CalculatorView view;
    private static CalculatorController instance = new CalculatorController();

    private CalculatorController() {
        model = CalculatorImpl.getInstance();
        view = CalculatorView.getInstance();
    }

    public static CalculatorController getInstance() {
        return instance;
    }

    public void calculateAdd() {
        view.showInitMsg();

        String userInput = view.getUserInput();

        model.setSeparator(userInput, new CustomExpression());

        try {
            model.parseNumbersFromString(userInput);

            long result = model.addNumbers();

            view.showResultMsg(result);
        } catch (IllegalArgumentException e) {
            view.showResultMsg(e);
            throw e;
        } finally {
            view.finishProgram();
        }
    }

    public void reset() {
        CalculatorImpl.reset();
        model = CalculatorImpl.getInstance();
    }
}
