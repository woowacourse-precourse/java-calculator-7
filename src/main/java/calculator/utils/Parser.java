package calculator.utils;

public class Parser {
    private SeparatorParser separatorParser;
    private OperandParser operandParser;

    public Parser() {
        separatorParser = new SeparatorParser();
        operandParser = new OperandParser();
    }

    public void parse(String inputString) {
        separatorParser.parseCustomSeparator(inputString);
        separatorParser.addBasicSeparator();
        operandParser.parseOperand(separatorParser.getRemovedString(), separatorParser.getSeparator());
    }
}
