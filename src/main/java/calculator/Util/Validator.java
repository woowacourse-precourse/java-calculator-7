package calculator.Util;

import java.util.List;

public class Validator {
    public static void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            return;
        }

        List<Integer> numbers;
        if (input.startsWith("//")) {
            numbers = Parser.parseWithCustomDelimeter(input);
        } else {
            numbers = Parser.parseWithDefaultDelimeter(input);
        }

        for (Integer number : numbers) {
            if (number < 0) { //음수일 경우
                throw new IllegalArgumentException();
            }
        }
    }
}
