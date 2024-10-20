package calculator.controller;

import calculator.model.Separator;

public class Calculator {
    private String input;

    public Calculator(String input) {
        this.input = input;

    }
    public void parseInput(){
        Separator.checkCustomSeparator(input);
    }
}
