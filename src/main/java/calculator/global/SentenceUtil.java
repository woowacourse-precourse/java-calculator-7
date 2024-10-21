package calculator.global;

import java.util.ArrayList;
import java.util.List;

public class SentenceUtil {
    public static String extractSentence(String input) {
        String result = input;
        if (input.contains("\\n")) {
            result = input.substring(input.indexOf("\\n") + 2);
        }
        validSentence(result);
        return result;
    }

    public static void validSentence(String input) {
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
            if (!number.matches("[0-9]+")) {
                throw new IllegalArgumentException("잘못된 입력 값 입니다.");
            }
        }
    }
}
