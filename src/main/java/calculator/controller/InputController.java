package calculator.controller;

import calculator.parser.InputParser;

import java.util.List;

public class InputController {
    private final InputParser parser;

    public InputController(InputParser parser) {
        this.parser = parser;
    }

    public void processInput(String input) {
        parser.validateInput(input);
        String trimmedInput = parser.processSpace(input);
        List<Integer> numbers = parser.parse(trimmedInput);
    }
}
