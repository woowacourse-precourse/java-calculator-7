package calculator.controller;

import calculator.model.inputValue.InputValue;
import calculator.view.screen.Screen;

public class Calculator {
    private InputValue inputValue;
    private Screen screen = new Screen();

    public Calculator(){
        inputValue = new InputValue(screen.getUserInput());
        screen.showResult(inputValue.calculateSum());
    }
}
