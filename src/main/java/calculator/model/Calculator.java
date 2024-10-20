package calculator.model;

import static calculator.model.token.ParsingPattern.DEFAULT_DELIMITER_PATTERN;

import calculator.model.token.CustomDelimiterToken;
import calculator.model.token.NumbersToken;
import calculator.model.token.Tokenizer;

public class Calculator {

    private boolean defaultMode;
    private Tokenizer tokenizer;

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

    public int sum(Numbers numbers) {
        return numbers.sum();
    }

    public Delimiter selectDelimiter(String input) {
        if (defaultMode) {
            return new Delimiter(DEFAULT_DELIMITER_PATTERN.getPattern());
        }

        CustomDelimiterToken customDelimiterToken = tokenizer.createCustomDelimiterToken(input);
        return new Delimiter(customDelimiterToken.extractDelimiter());
    }

    public void setMode(String input) {
        if (tokenizer.isExistsCustomDelimiterToken(input)) {
            defaultMode = false;
        } else {
            defaultMode = true;
        }
    }
}
