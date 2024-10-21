package calculator.model;

import static calculator.model.Calculator.Mode.CUSTOM;
import static calculator.model.Calculator.Mode.DEFAULT;
import static calculator.model.enums.ParsingPattern.DEFAULT_DELIMITER_PATTERN;
import static calculator.util.Converter.convertToNumbersFromNumbersToken;
import static calculator.util.Tokenizer.createCustomDelimiterToken;
import static calculator.util.Tokenizer.createNumbersToken;
import static calculator.util.Tokenizer.isExistsCustomDelimiterToken;

// 계산 기능의 전반적인 로직 수행
public class Calculator {
    enum Mode {
        DEFAULT,
        CUSTOM
    }

    private Mode mode;

    private static final int EMPTY_RESULT = 0;

    public Calculator() {
        this.mode = DEFAULT;
    }

    public int calculate(String input) {
        setMode(input);

        Delimiter delimiter = selectDelimiter(input);

        NumbersToken numbersToken = createNumbersToken(input);

        if (numbersToken.isEmpty()) {
            return EMPTY_RESULT;
        }

        return sum(convertToNumbersFromNumbersToken(delimiter, numbersToken));
    }

    private int sum(Numbers numbers) {
        return numbers.sum();
    }

    private Delimiter selectDelimiter(String input) {
        if (mode == DEFAULT) {
            return new Delimiter(DEFAULT_DELIMITER_PATTERN.getPattern());
        }

        CustomDelimiterToken customDelimiterToken = createCustomDelimiterToken(input);
        return new Delimiter(customDelimiterToken.extractDelimiter());
    }

    private void setMode(String input) {
        if (isExistsCustomDelimiterToken(input)) {
            mode = CUSTOM;
        } else {
            mode = DEFAULT;
        }
    }
}
