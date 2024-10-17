package calculator;

import java.util.*;

public class Validator {
    public static void validate(List<String> numbers) {
        for (String number : numbers) {
            try {
                int n = Integer.parseInt(number);
                if (n < 0) throw new InvalidNumberFormatException();
            } catch (NumberFormatException e) {
                throw new InvalidNumberFormatException();
            }
        }
    }
}
