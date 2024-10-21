package calculator.service;

import calculator.InputValidator;
import calculator.domain.Delimiter;
import calculator.domain.Operands;
import calculator.util.InputParser;
import java.util.List;

public class Calculator {
    private Operands operands;

    public void parseAndAddNumbers(String input) {
        Delimiter delimiter = new Delimiter();
        if (input.startsWith("//")) {
            String customDelimiter = InputParser.extractCustomDelimiter(input);
            delimiter.addCustomDelimiter(customDelimiter);
        }

        String numbersSection = InputParser.extractNumbersSection(input);
        String[] tokens = delimiter.split(numbersSection);
        InputValidator.validateNumbers(tokens);

        this.operands = new Operands(List.of(tokens));
    }

    public int sum() {
        return operands.sum();
    }
}
