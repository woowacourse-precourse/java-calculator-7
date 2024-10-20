package calculator.domain;

import calculator.util.Delimiter;
import java.util.Arrays;
import java.util.List;

public class InputProcessor {

    private static final String DEFAULT_DELIMITER = ",|:";

    public List<String> splitInput(String input) {
        String delimiter = DEFAULT_DELIMITER;
        String inputNumbers = input;

        if (Delimiter.hasCustomDelimiter(input)) {
            delimiter = Delimiter.extractDelimiter(input);
            inputNumbers = input.substring(input.indexOf("\n") + 1);
        }

        return Arrays.asList(inputNumbers.split(delimiter));
    }
}
