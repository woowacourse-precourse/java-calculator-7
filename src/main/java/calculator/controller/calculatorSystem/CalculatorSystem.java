package calculator.controller;

import calculator.model.inputValue.InputValue;
import calculator.view.screen.Screen;

public class CalculatorSystem {
    private InputValue inputValue;
    private Screen screen = new Screen();

    public CalculatorSystem(){
        inputValue = new InputValue(screen.getUserInput());
        screen.showResult(inputValue.calculateSum());
    }
}
