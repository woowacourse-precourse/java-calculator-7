package calculator.model;

import static java.util.regex.Pattern.quote;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    public List<Integer> checkAndParseInput(String input) throws IllegalArgumentException{
        if (input == null) {
            return List.of(0,0);
        }
        if (checkDefaultDelimiter(input)) {
            return convertDefaultDelimiter(input);
        }
        throw new IllegalArgumentException();
    }

    protected boolean checkDefaultDelimiter(String input) {
        String defaultDelimiterRegex = "^([1-9]\\d*)((,|:)([1-9]\\d*))*$";
        return input.matches(defaultDelimiterRegex);
    }

    protected List<Integer> convertDefaultDelimiter(String input) throws IllegalArgumentException {
        try {
            input = input.replace(","," ").replace(":"," ");
            String[] inputs = input.split(" ");
            return Arrays.stream(inputs)
                         .map(Integer::parseInt)
                         .toList();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    protected boolean checkCustomDelimiter(String input) {
        return input.contains("//") && input.contains("\\n");
    }
}
