package calculator;

public class StringProcessor {
    public static String[] splitWithDelimiter(String expression) {
        return expression.split(",|;");
    }
}
