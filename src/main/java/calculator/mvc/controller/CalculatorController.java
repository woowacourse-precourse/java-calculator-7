package calculator.mvc.controller;

import calculator.mvc.model.Calculator;
import calculator.mvc.model.CalculatorImpl;
import calculator.mvc.model.CustomExpression;
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

        String customExpression = new CustomExpression().makeExpression(userInput);

        try {
            model.parseNumbersFromString(userInput, customExpression);

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
