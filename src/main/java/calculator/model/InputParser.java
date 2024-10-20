package calculator.model;

import java.util.List;

public class InputParser {
    public static InputParser getInstance() {
        return new InputParser();
    }

    public String[] parseByDelimiter(String input, List<String> delimiters) {
        String regex = String.join("|", delimiters);
        return trim(input.split(regex));
    }

    private String[] trim(String[] tokens) {
        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = tokens[i].trim();
        }
        return tokens;
    }

}


