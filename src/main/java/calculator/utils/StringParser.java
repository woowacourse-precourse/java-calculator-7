package calculator.utils;

import calculator.model.InputValidator;

public class StringParser {
    private final InputValidator validator;

    public StringParser() {
        this.validator = InputValidator.getInstance();
    }
    public int[] parse(String input) {
        validator.validate(input);
        String[] parts = input.split(",");
        int[] numbers = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i].trim());
        }
        return numbers;
    }
}
