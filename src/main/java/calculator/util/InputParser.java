package calculator.util;

import calculator.domain.Delimiter;

public class InputParser {

    public static String getDelimiter(String input) {
        if (input.startsWith("//")) {
            return Delimiter.extractDelimiter(input);
        }
        return "[,:]";
    }
}
