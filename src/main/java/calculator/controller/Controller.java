package calculator.controller;

import calculator.service.Calculator;
import calculator.service.Separator;
import calculator.view.View;

public class Controller {
    private final View view;
    private final Separator separator;
    private final Calculator calculator;

    public Controller(View view, Separator separator, Calculator calculator) {
        this.view = view;
        this.separator = separator;
        this.calculator = calculator;
    }

    public void run() {
        String input = view.inputAddedNumber();
        int[] separatedInput = separator.separate(input);
        int result = calculator.add(separatedInput);
        view.outputAddedResult(result);
    }

}
