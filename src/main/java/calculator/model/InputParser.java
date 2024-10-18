package calculator.model;

import java.util.List;

public class InputParser {

    public static InputParser getInstance() {
        return new InputParser();
    }

    public String[] parseByDelimiter(String input, List<String> delimiters) {
        String regex = String.join("|", delimiters);
        return input.split(regex);
    }
}

