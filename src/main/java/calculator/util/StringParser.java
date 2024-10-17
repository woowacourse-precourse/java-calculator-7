package calculator.util;

import java.util.Arrays;
import java.util.List;

public class StringParser {

    public static List<String> parseInput(final String input) {

        return Arrays.asList(input.split(",|:"));
    }
}
