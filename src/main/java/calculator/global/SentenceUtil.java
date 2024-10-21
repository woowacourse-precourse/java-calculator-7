package calculator.global;

import java.util.List;

public class SentenceUtil {
    public static String extractSentence(String input) {
        if (input.contains("\\n")) {
            return input.substring(input.indexOf("\\n") + 2);
        }
        return input;
    }

    public static void validNumbers(List<String> numbers) {
        for (String number : numbers) {
            if (!number.matches("[0-9]+")) {
                throw new IllegalArgumentException();
            }
        }
    }
}
