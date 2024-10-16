package calculator.controller;

import calculator.model.InputData;
import calculator.view.InputView;

public class StringCalculatorController {
    private final InputView inputView;

    public StringCalculatorController() {
        this.inputView = new InputView();
    }

    public InputData handoverInput(String input){
        return new InputData(input);
    }
}
