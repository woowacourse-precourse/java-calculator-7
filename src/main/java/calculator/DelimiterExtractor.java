package calculator;

public class DelimiterExtractor {

    public static boolean hasDelimiter(String regex, String text) {
        String result = text.replaceAll(regex, " ");
        return !result.isBlank();
    }
}
