package calculator;

import java.util.List;

public class InputParser {
    private final DelimiterParser delimiterParser;
    private final NumberExtractor numberExtractor;

    public InputParser(String input) {
        this.delimiterParser = new DelimiterParser(input);
        this.numberExtractor = new NumberExtractor();
    }

    public List<Integer> parse(){
        String delimiters = delimiterParser.getDelimiters();
        String numbersString = delimiterParser.getNumbersString();
        return numberExtractor.extractNumbers(numbersString,delimiters);
    }

}
