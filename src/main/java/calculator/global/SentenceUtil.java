package calculator.global;

import java.util.ArrayList;
import java.util.List;

public class SentenceUtil {
    private static final int PADDING = 2;
    private static final String ONLY_NUMERIC = "[0-9]+";
    public static String extractSentence(String input) {
        String result = input;
        if (input.contains("\\n")) {
            result = input.substring(input.indexOf("\\n") + PADDING);
        }
        validSentence(result);
        return result;
    }

    private static void validSentence(String input) {
        List<String> numbers = new ArrayList<>();
        int firstIndex = 0;
        int lastIndex = input.length()-1;
        String firstValue = String.valueOf(input.charAt(firstIndex));
        String lastValue = String.valueOf(input.charAt(lastIndex));
        numbers.add(firstValue);
        numbers.add(lastValue);
        validNumbers(numbers);
    }
    public static void validNumbers(List<String> numbers) {
        for (String number : numbers) {
            if (!number.matches(ONLY_NUMERIC)) {
                throw new IllegalArgumentException("잘못된 입력 값 입니다.");
            }
        }
    }
}
