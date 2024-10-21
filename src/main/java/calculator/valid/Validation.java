package calculator.valid;

import java.util.List;

public class Validation {

    public static void validation(List<Integer> numberList) {
        for (Integer number : numberList) {
            if (number < 0) {
                throw new IllegalArgumentException();
            }
        }
    }

}
