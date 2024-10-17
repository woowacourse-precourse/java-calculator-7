package calculator.service;

import calculator.model.Numbers;
import calculator.utils.DelimiterFilter;
import calculator.utils.Parser;
import java.util.List;

public class CalculatorService {

    private final Parser parser;
    private final DelimiterFilter delimiterFilter;

    public CalculatorService(Parser parser, DelimiterFilter delimiterFilter) {
        this.parser = parser;
        this.delimiterFilter = delimiterFilter;
    }

    public Integer getResult(String input) {
        String pureString = input;
        boolean hasCustomDelimiter = delimiterFilter.hasCustomDelimiter(input);
        List<Character> delimiter = delimiterFilter.getDelimiter(hasCustomDelimiter, pureString);
        if (hasCustomDelimiter) {
            pureString = delimiterFilter.getPureString(pureString);
        }
        Numbers numbers = parser.parseInput(delimiter, pureString);
        return numbers.sumNumbers();
    }
}
