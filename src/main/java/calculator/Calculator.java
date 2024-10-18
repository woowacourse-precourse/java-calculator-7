package calculator;

public class Calculator {

    private final String input;
    private final InputValidator inputValidator;
    private final DelimiterValidator validator;
    private final NumberExtractor extractor;

    public Calculator(String input) {
        this.input = input;
        this.inputValidator = new InputValidator();
        this.validator = new DelimiterValidator(input);
        this.extractor = new NumberExtractor();
    }

    public int sum() {
        if (inputValidator.hasInput(input)) {
            return 0;
        }

        if (validator.validateCustomDelimiter()) {
            return extractor.customDelimiterExtractNumber(input);
        }

        return extractor.defaultDelimiterExtractNumber(input);
    }
}
