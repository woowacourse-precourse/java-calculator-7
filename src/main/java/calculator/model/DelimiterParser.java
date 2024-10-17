package calculator.model;

import static calculator.util.Constant.DEFAULT_DELIMITERS;

public class DelimiterParser {

    private final InputValidator inputValidator;

    public DelimiterParser(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public String[] parse(String input) {
        if (input.startsWith("//")) {
            String[] parts = inputValidator.splitInput(input);
            String customDelimiter = parts[0].substring(2);
            inputValidator.validateCustomDelimiter(customDelimiter);
            inputValidator.validateInputContent(parts[1], customDelimiter);
            return inputValidator.splitByDelimiter(parts[1], customDelimiter);
        }

        inputValidator.validateDefaultDelimiterContent(input);
        return input.split(DEFAULT_DELIMITERS);
    }
}
