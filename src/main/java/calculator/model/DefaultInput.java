package calculator.model;

import java.util.Arrays;
import java.util.regex.Pattern;

public class DefaultInput extends UserInput {

    public DefaultInput(String userInput) {
        super(userInput);
    }

    @Override
    protected void parseInputForCalculate(String userInput) {
        String[] splitValues = splitCalculatePartByDelimiters(userInput);
        checkValueToCalculateIsNumber(splitValues);

        inputNumbers = Arrays.stream(splitValues)
                .mapToLong(Long::parseLong)
                .toArray();
    }

    @Override
    protected String[] splitCalculatePartByDelimiters(String calculatePart) {
        String regex = String.join("|", delimiters.stream().map(Pattern::quote).toArray(String[]::new));

        return calculatePart.split(regex);
    }

}
