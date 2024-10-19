package calculator.parser;

import java.util.List;

public class Parser {
    private final DelimiterParser delimiterParser;
    private final NumberParser numberParser;

    public Parser(){
        this.delimiterParser = new DelimiterParser();
        this.numberParser = new NumberParser();
    }

    public List<Integer> parser(String input){
        String delimiters = delimiterParser.parseDelimiter(input);
        String numbers = delimiterParser.extractNumbers(input);
        return numberParser.parseNumbers(numbers, delimiters);
    }
}
