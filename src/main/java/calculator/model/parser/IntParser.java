package calculator.model.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntParser implements NumberParser {

    @Override
    public boolean canParse(String[] userInput) {
        for (String userInputValue : userInput) {
            try {
                Integer.parseInt(userInputValue);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<Number> parse(String[] userInput) {
        return Arrays.stream(userInput)
                .map(Integer::parseInt)
                .map(Number.class::cast)
                .collect(Collectors.toList());
    }
}
