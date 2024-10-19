package calculator.controller;

import calculator.model.CalculatorModel;
import calculator.view.CalculatorView;
import java.util.List;

public class CalculatorController {
    private CalculatorView calculatorView;
    private CalculatorModel calculatorModel;

    public CalculatorController(CalculatorView view, CalculatorModel model) {
        calculatorView = view;
        calculatorModel = model;
    }

    public void start() {
        calculatorView = new CalculatorView();
        String input = calculatorView.getInput();
        List<Integer> operands = calculatorModel.parser(input);
    }
}
