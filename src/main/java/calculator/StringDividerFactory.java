package calculator;

public class StringDividerFactory {

    public static StringDivider createStringDivider(String input) {
        SeparatorParser separatorParser = new SeparatorParser(input);
        if (separatorParser.isCustomSeparatorExist()) {
            String customSeparator = separatorParser.getCustomSeparator();
            String mathExpression = separatorParser.getMathematicalExpression();
            return new StringDivider(customSeparator, mathExpression);
        }
        return new StringDivider(input);
    }

}
