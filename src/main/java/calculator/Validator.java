package calculator;

import java.util.*;

public class Validator {
    public static void validate(List<String> numbers) {
        for (String number : numbers) {
            try {
                float n = Float.parseFloat(number);
                if (n < 0) throw new InvalidNumberFormatException();
            } catch (NumberFormatException e) {
                throw new InvalidNumberFormatException();
            }
        }
    }
}
