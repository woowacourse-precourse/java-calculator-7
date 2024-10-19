package calculator;

public class DelimiterSeparator {

    private static final String COMMA_DELIMITER = ",";
    private static final String COLON_DELIMITER = ":";

    public static String[] split(String value, Delimiter delimiter) {
        return value.split(delimiter.getValue());
    }
}
