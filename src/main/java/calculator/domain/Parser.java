package calculator.domain;

import java.util.Arrays;
import java.util.List;

import static calculator.domain.Delimiter.getCustomDelimiter;

public class Parser {
    public static List<String> splitInput(String input) {
        String delimiter = ",:";

        if (getCustomDelimiter(input) != null) {
            delimiter += getCustomDelimiter(input);
        }

        return Arrays.asList(input.split(delimiter));
    }
}
