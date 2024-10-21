package calculator.model;

import static calculator.model.Calculator.Mode.CUSTOM;
import static calculator.model.Calculator.Mode.DEFAULT;
import static calculator.model.token.ParsingPattern.DEFAULT_DELIMITER_PATTERN;

import calculator.model.token.CustomDelimiterToken;
import calculator.model.token.NumbersToken;
import calculator.model.token.Tokenizer;

public class Calculator {

    enum Mode {
        DEFAULT,
        CUSTOM
    }

    private Mode mode;
    private final Tokenizer tokenizer;

    private static final int EMPTY_RESULT = 0;

    public Calculator() {
        this.tokenizer = new Tokenizer();
    }

    public int calculate(String input) {
        setMode(input);

        Delimiter delimiter = selectDelimiter(input);

        NumbersToken numbersToken = tokenizer.createNumbersToken(input);

        if (numbersToken.isEmpty()) {
            return EMPTY_RESULT;
        }

        Numbers numbers = numbersToken.convertToNumbers(delimiter);

        return sum(numbers);
    }

    private int sum(Numbers numbers) {
        return numbers.sum();
    }

    private Delimiter selectDelimiter(String input) {
        if (mode == DEFAULT) {
            return new Delimiter(DEFAULT_DELIMITER_PATTERN.getPattern());
        }

        CustomDelimiterToken customDelimiterToken = tokenizer.createCustomDelimiterToken(input);
        return new Delimiter(customDelimiterToken.extractDelimiter());
    }

    private void setMode(String input) {
        if (tokenizer.isExistsCustomDelimiterToken(input)) {
            mode = CUSTOM;
        } else {
            mode = DEFAULT;
        }
    }
}
