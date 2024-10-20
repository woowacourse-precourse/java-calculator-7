package calculator;

import java.util.List;

public class InputValidator {

    public static void validateNumbers(List<Integer> numbers) {
        List<Integer> negativeNumbers = numbers.stream()
                .filter(num -> num < 0)
                .toList();
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException(
                    String.format("음수는 허용되지 않습니다: %s", negativeNumbers)
            );
        }
    }

    public static void validateStart(String numbersString, String delimiters) {
        if (startsWithDelimiter(numbersString, delimiters)) {
            throw new IllegalArgumentException("입력의 첫 글자가 구분자입니다. 올바른 형식으로 다시 입력해 주세요.");
        }
    }

    private static boolean startsWithDelimiter(String input, String delimiters) {
        for (String delimiter : delimiters.split("\\|")) {
            if (input.startsWith(delimiter)) {
                return true;
            }
        }
        return false;
    }
}
