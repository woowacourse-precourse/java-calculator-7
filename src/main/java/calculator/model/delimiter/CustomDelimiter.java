package calculator.model.delimiter;

public class CustomDelimiter{
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private static final int PREFIX_LENGTH = 2;
    private final String delimiter;

    public CustomDelimiter(String expression){
        this.delimiter = extractCustomDelimiter(expression);
    }

    public String getDelimiter() {
        return delimiter;
    }

    public boolean hasCustomDelimiter(String expression) {
        return expression.startsWith(CUSTOM_DELIMITER_PREFIX) && expression.contains(CUSTOM_DELIMITER_SUFFIX);
    }

    private String extractCustomDelimiter(String expression) {
        return hasCustomDelimiter(expression)
            ? expression.substring(PREFIX_LENGTH, expression.indexOf(CUSTOM_DELIMITER_SUFFIX))
            : null;
    }

    public String getAffixDelimiter(){
        return delimiter != null
            ? CUSTOM_DELIMITER_PREFIX + delimiter + CUSTOM_DELIMITER_SUFFIX
            : null;
    }
}
