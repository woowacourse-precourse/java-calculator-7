package calculator;

import java.util.List;
import java.util.Set;

public class Calculator {
    private final InputReader inputReader;
    private final InputValidator inputValidator;
    private final DelimiterParser delimiterParser;
    private final NumberExtractor numberExtractor;
    private final NumberAdder numberAdder;

    public Calculator(InputReader inputReader, InputValidator inputValidator,
                      DelimiterParser delimiterParser,
                      NumberExtractor numberExtractor, NumberAdder numberAdder) {
        this.inputReader = inputReader;
        this.inputValidator = inputValidator;
        this.delimiterParser = delimiterParser;
        this.numberExtractor = numberExtractor;
        this.numberAdder = numberAdder;
    }

    public void run() {
        String input = inputReader.readInput();
        inputValidator.validate(input);

        Set<Character> delimiters = delimiterParser.parseDelimiters(input);
        String processedInput = delimiterParser.removeCustomDelimiterSection(input);

        List<Integer> numbers = numberExtractor.extract(processedInput, delimiters);
        int result = numberAdder.sum(numbers);

        System.out.println("결과 : "+result);
    }
}