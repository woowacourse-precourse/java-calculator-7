package calculator.calculator;

import calculator.parser.NumberParser;
import calculator.validator.InputValidator;
import java.util.List;

public class StringCalculatorImpl implements Calculator {
    private final InputValidator inputValidator;
    private final calculator.extractor.developed.NumberExtractorChain NumberExtractorChain;
    private final NumberParser numberParser;

    public StringCalculatorImpl(InputValidator inputValidator,
                                calculator.extractor.developed.NumberExtractorChain NumberExtractorChain,
                                NumberParser numberParser) {
        this.inputValidator = inputValidator;
        this.NumberExtractorChain = NumberExtractorChain;
        this.numberParser = numberParser;
    }

    @Override
    public int calculate(String input) {
        inputValidator.validate(input);
        List<String> tokens = NumberExtractorChain.extract(input);
        List<Integer> numbers = numberParser.parseNumbers(tokens);
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
