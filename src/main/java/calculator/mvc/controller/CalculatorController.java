package calculator.mvc.controller;

import calculator.mvc.model.Calculator;
import calculator.mvc.model.CalculatorImpl;
import calculator.mvc.view.CalculatorView;
import java.util.NoSuchElementException;

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

        try {
            String userInput = view.getUserInput();

            model.findCustomSeparator(userInput);

            model.parseNumbersFromString(userInput);

            long result = model.addNumbers();

            view.showResultMsg(result);
        } catch (NoSuchElementException e) {
            view.showResultMsg(0);
        } catch (IllegalArgumentException e) {
            view.showResultMsg(e);
            throw e;
        } finally {
            view.finishProgram();
        }
    }

    public void reset() {
        model = CalculatorImpl.reset();
    }
}
