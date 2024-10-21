package calculator.controller;

import calculator.model.Numbers;
import calculator.model.Separators;
import calculator.view.CalculatorView;

public class CalculatorController {
    private final CalculatorView view;

    public CalculatorController(CalculatorView view) {
        this.view = view;
    }

    public void run() {
        String input = view.getInput();

        Separators separators = Separators.parseFrom(input);
        Numbers numbers = Numbers.parseOf(input, separators);

        view.printResult(numbers.sum());
    }
}
