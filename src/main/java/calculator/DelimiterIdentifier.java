package calculator;

public class DelimiterIdentifier {

    public static final String DEFAULT_DELIMITERS = ",:";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_POSTFIX = "\\n";

    public String getDelimiter(String input) throws IllegalArgumentException {
       if (!input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
           return DEFAULT_DELIMITERS;
       }
       int customDelimiterPostfixIdx = input.lastIndexOf(CUSTOM_DELIMITER_POSTFIX);
       if (customDelimiterPostfixIdx == -1) {
           throw new IllegalArgumentException();
       }
       return getCustomDelimiter(input, customDelimiterPostfixIdx);
   }

   private String getCustomDelimiter(String input, int customDelimiterPostfixIdx) {
        int customDelimiterIdx = CUSTOM_DELIMITER_PREFIX.length();
        if (!(customDelimiterIdx < customDelimiterPostfixIdx))
            throw new IllegalArgumentException();
        return input.substring(customDelimiterIdx, customDelimiterPostfixIdx);
   }
}
