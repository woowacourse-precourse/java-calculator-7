package calculator.util.parser;

public interface StringParser {

    String extractCustomDelimiter(final String str);

    String removeCustomDelimiterFormat(final String str);

    String[] extractTokens(final String str);

    String getDelimiterRegex(final String customDelimiter);
}
