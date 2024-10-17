package parser;

import global.DefaultDelimiter;

public class InputParser {

    private static final InputParser INSTANCE = new InputParser();
    private final Delimiter delimiter = new Delimiter();

    private InputParser() {
    }

    public static InputParser getInstance() {
        return INSTANCE;
    }

    public String[] parse(String input) {
        String customDelimiter = delimiter.extractDelimiter(input);
        if (!delimiter.validateHasDefaultOrCustomDelimiter(input, customDelimiter)) {
            throw new IllegalArgumentException("허용되지 않는 입력문입니다.");
        }
        String defaultSyntax = delimiter.removeDelimiterSyntax(input);
        return extractNumbersFromDefaultSyntax(defaultSyntax, customDelimiter);
    }

    private String[] extractNumbersFromDefaultSyntax(String defaultSyntax, String customDelimiter) {
        String delimiters = DefaultDelimiter.COMMA.getKey() + DefaultDelimiter.COLON.getKey() + customDelimiter;
        return defaultSyntax.split("[" + delimiters + "]");
    }
}
