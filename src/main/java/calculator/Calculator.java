package calculator;

import java.util.List;

import static java.lang.String.format;

public class Calculator {
    private static final String FIRST_DELIMITER = ",";
    private static final String SECOND_DELIMITER = ":";

    private static List<String> parseNumbers(final String input) {
        return List.of(input.split(format("[%s|%s]", FIRST_DELIMITER, SECOND_DELIMITER)));
    }
}
