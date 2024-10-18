package calculator.calculator;

import calculator.extractor.TokenExtractor;
import calculator.parser.NumberParser;
import calculator.validator.InputValidator;
import java.util.List;

public class StringCalculatorImpl implements Calculator {
    private final InputValidator inputValidator;
    private final TokenExtractor tokenExtractor;
    private final NumberParser numberParser;

    public StringCalculatorImpl(InputValidator inputValidator, TokenExtractor tokenExtractor,
                                NumberParser numberParser) {
        this.inputValidator = inputValidator;
        this.tokenExtractor = tokenExtractor;
        this.numberParser = numberParser;
    }

    @Override
    public int calculate(String input) {
        inputValidator.validate(input);
        List<String> tokens = tokenExtractor.extract(input);
        List<Integer> numbers = numberParser.parseNumbers(tokens);
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
