package calculator;

public class DelimiterSeparator {

    public static String[] split(String value, Delimiter delimiter) {
        return value.split(delimiter.getValue());
    }
}
