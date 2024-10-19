package calculator;

public class DelimiterSeparator {

    private static final String COMMA_DELIMITER = ",";
    private static final String COLON_DELIMITER = ":";

    public static String[] split(String value) {
        return value.split(COMMA_DELIMITER + COLON_DELIMITER);
    }
}
