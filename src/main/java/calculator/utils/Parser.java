package calculator.utils;

import java.util.List;

public class Parser {
    private final SeparatorParser separatorParser;
    private final OperandParser operandParser;

    public Parser() {
        separatorParser = new SeparatorParser();
        operandParser = new OperandParser();
    }

    public List<Integer> parse(String inputString) {
        separatorParser.parse(inputString);
        separatorParser.addBasicSeparator();
        return operandParser.parse(
                separatorParser.getParseInputString(),
                separatorParser.getSeparator());
    }
}
