package calculator.service;

import calculator.common.InputValidator;
import calculator.common.StringParser;
import calculator.domain.Delimiter;
import calculator.domain.Operands;
import java.util.List;

public class Calculator {
    private Operands operands;

    public void parseAndAddNumbers(String input) {
        Delimiter delimiter = new Delimiter();
        if (input.startsWith("//")) {
            String customDelimiter = StringParser.extractCustomDelimiter(input);
            delimiter.addCustomDelimiter(customDelimiter);
        }

        String numbersSection = StringParser.extractNumbersSection(input);
        String[] tokens = delimiter.split(numbersSection);
        InputValidator.validateNumbers(tokens);

        this.operands = new Operands(List.of(tokens));
    }

    public int sum() {
        return operands.sum();
    }
}
