package calculator.service;

import calculator.parser.InputParser;

public class SeparateService {
    private final InputParser inputParser = InputParser.getInstance();

    public String[] separate(String input) {
        return inputParser.separate(input);
    }
}
