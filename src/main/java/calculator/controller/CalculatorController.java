package calculator.controller;

import calculator.model.CalculatorModel;
import calculator.utils.Parser;
import calculator.view.CalculatorView;

public class CalculatorController {
    private final CalculatorModel model;
    private final CalculatorView view;
    private final Parser parser;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
        this.parser = new Parser();
    }

    public void run() {
        String inputString = view.getUserInput();
        parseCustomSeparator();
        addBasicSeparator();
        parseOperand();
        view.printResult();
    }
}
