package calculator.domain.calculation;

import calculator.domain.parser.vo.PositiveNumbers;
import java.util.List;

public class StringCalculator implements Calculator {
    private final InputValidator inputValidator;
    private final NumberExtractor numberExtractor;
    private final NumberParser numberParser;

    public StringCalculator(InputValidator inputValidator, NumberExtractor numberExtractor,
                            NumberParser numberParser) {
        this.inputValidator = inputValidator;
        this.numberExtractor = numberExtractor;
        this.numberParser = numberParser;
    }

    @Override
    public int calculate(String input) {
        inputValidator.validate(input);
        List<String> stringNumbers = numberExtractor.extract(input);
        PositiveNumbers positiveNumbers = numberParser.parseNumbers(stringNumbers);
        return positiveNumbers.sum();
    }
}
