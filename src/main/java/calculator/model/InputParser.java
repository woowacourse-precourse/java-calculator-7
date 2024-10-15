package calculator.model;

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
        String defaultDelimiterRegex = "(^[1-9]\\d*)((,|:)([1-9]\\d*))*$";
        return input.matches(defaultDelimiterRegex);
    }
    
    }
}
