package calculator.view;

import calculator.domain.Delimeters;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    private static final int START_INDEX = 0;
    private static final String CUSTOM_START = "//";
    private static final String CUSTOM_END = "\\n";

    public List<Integer> parseInput(Delimeters delimiters, String input) {
        String delimiterRegex = String.join("|", delimiters.getElements());
        String[] tokens = input.split(delimiterRegex);
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            numbers.add(Integer.parseInt(token.trim()));
        }
        return numbers;
    }

    public String parseCustomDelimiter(String input) {
        return input.substring(START_INDEX, input.indexOf(CUSTOM_END))
                .replace(CUSTOM_START, "");
    }
}
