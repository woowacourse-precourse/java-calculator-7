package calculator.service;

import calculator.util.CalculatorParser;

import java.util.List;

public class CalculatorManager {
    private final CalculatorNumberList numberList;

    public CalculatorManager(String input) {
        final Delimiter delimiter = new CalculatorDelimiter(input);
        final String regex = delimiter.getDelimiterRegex();
        final String content = delimiter.getContentWithoutDelimiter();
        final List<Integer> parsed = CalculatorParser.parseInteger(regex, content);
        numberList = new CalculatorNumberList(parsed);
    }

    public int calculateSum() {
        return numberList.sum();
    }
}
