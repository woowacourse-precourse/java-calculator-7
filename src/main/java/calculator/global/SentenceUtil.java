package calculator.global;

public class SentenceUtil {
    public static String extractSentence(String input) {
        if (input.contains("\\n")) {
            return input.substring(input.indexOf("\\n") + 2);
        }
        return input;
    }
}
