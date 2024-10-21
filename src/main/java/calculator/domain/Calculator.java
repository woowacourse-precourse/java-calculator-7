package calculator.domain;

public class Calculator {
    private final DelimiterParser delimiterParser;
    private final StringSplitter stringSplitter;

    public Calculator(DelimiterParser delimiterParser, StringSplitter stringSplitter) {
        this.delimiterParser = delimiterParser;
        this.stringSplitter = stringSplitter;
    }

//    public int calculate(String input) {
//        String delimiter = delimiterParser.parse(input);
//        String[] numbers = stringSplitter.split(input, delimiter);
//        return sum(numbers);
//    }
}
