package calculator.view.input.parser;

public class DelimiterParserManager {
    private static final String CUSTOM_PREFIX = "//";
    private static final String CUSTOM_POSTFIX = "\\n";

    public DelimiterParser getDelimiterParser(String input) {
        if (input.startsWith(CUSTOM_PREFIX) && input.contains(CUSTOM_POSTFIX)) {
            return new CustomDelimiterParser();
        }
        return new DefaultDelimiterParser();
    }
}
