package calculator.validation;

import java.util.List;

public class Validator {

    public static void validateInput(String input) {
        if (input.startsWith("//")) {
            if (!input.matches("//(.)\\\\n([0-9,:]*\\1*)*")) {
                throw new IllegalArgumentException();
            }
        }else {
            if (!input.matches("[0-9,:]+")) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateNegative(List<Integer> numbers) {
        for(Integer number : numbers) {
            if(number < 0) {
                throw new IllegalArgumentException();
            }
        }
    }
}
