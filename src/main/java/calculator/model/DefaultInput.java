package calculator.model;

import calculator.common.ExceptionMessage;

import java.util.Arrays;
import java.util.regex.Pattern;

public class DefaultInput extends UserInput {

    public DefaultInput(String userInput) {
        super(userInput);
    }

    @Override
    protected void parseInputForCalculate(String userInput) {
        inputNumbers = userInput.isEmpty()
                ? new long[]{0}
                : parseStringToLongArray(userInput);
    }

    private long[] parseStringToLongArray(String userInput) {
        String[] splitValues = splitCalculatePartByDelimiters(userInput);

        try {
            return Arrays.stream(splitValues)
                    .mapToLong(Long::parseLong)
                    .filter(this::checkNumIsPositive)
                    .toArray();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.CALCULATE_PART_IS_INVALID.getValue());
        }
    }

    @Override
    protected String[] splitCalculatePartByDelimiters(String calculatePart) {
        String regex = String.join(REGEX_DELIMITER, delimiters.stream().map(Pattern::quote).toArray(String[]::new));

        return calculatePart.split(regex);
    }

}
