package calculator.controller;

import calculator.parser.InputParser;

public class InputController {
    private final InputParser parser;

    public InputController(InputParser parser) {
        this.parser = parser;
    }

    public void processInput(String input) {
        parser.validateInput(input);
    }
}
