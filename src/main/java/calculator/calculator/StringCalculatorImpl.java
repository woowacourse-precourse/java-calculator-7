package calculator.calculator;

import calculator.extractor.developed.NumberExtractorChain;
import calculator.parser.NumberParser;
import calculator.parser.PositiveNumbers;
import calculator.validator.InputValidator;
import java.util.List;

public class StringCalculatorImpl implements Calculator {
    private final InputValidator inputValidator;
    private final NumberExtractorChain numberExtractorChain;
    private final NumberParser numberParser;

    public StringCalculatorImpl(InputValidator inputValidator, NumberExtractorChain numberExtractorChain,
                                NumberParser numberParser) {
        this.inputValidator = inputValidator;
        this.numberExtractorChain = numberExtractorChain;
        this.numberParser = numberParser;
    }

    @Override
    public int calculate(String input) {
        inputValidator.validate(input);
        List<String> tokens = numberExtractorChain.extract(input);
        PositiveNumbers positiveNumbers = numberParser.parseNumbers(tokens);
        return positiveNumbers.sum();
    }
}
