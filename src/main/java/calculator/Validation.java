package calculator;

import java.util.Arrays;

public class Validation {
    public static boolean inputCheck(String input) {
        String inputPattern = "(//\\D\\\\n)*([0-9]+)(\\D[0-9]+)*";
        return input.matches(inputPattern);
    }

    public static boolean formatCheck(String[] values) {
        return Arrays.stream(values).allMatch(value -> value.matches("[0-9]+"));
    }
}