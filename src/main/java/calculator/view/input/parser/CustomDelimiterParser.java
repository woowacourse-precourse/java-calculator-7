package calculator.view.input.parser;

public class CustomDelimiterParser extends DefaultDelimiterParser {
    private static final String CUSTOM_PREFIX = "//";
    private static final String CUSTOM_POSTFIX = "\\n";
    private static final String WHITESPACE = " ";

    @Override
    public String removeDelimiter(String input) {
        int postfixIndex = input.indexOf(CUSTOM_POSTFIX);
        String customDelimiter = input.substring(CUSTOM_PREFIX.length(), postfixIndex);
        String numbersString = input.substring(postfixIndex + CUSTOM_POSTFIX.length());
        numbersString = super.removeDelimiter(numbersString);
        return numbersString.replace(customDelimiter, WHITESPACE);
    }
}
