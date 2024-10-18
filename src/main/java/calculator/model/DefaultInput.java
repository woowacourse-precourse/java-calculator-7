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
                .map(value -> value.isEmpty() ? ZERO_VALUE : value)  // 빈 문자열을 "0"으로 치환
                .mapToLong(Long::parseLong) // Long으로 변환
                .toArray();
    }

    @Override
    protected String[] splitCalculatePartByDelimiters(String calculatePart) {
        String regex = String.join(REGEX_DELIMITER, delimiters.stream().map(Pattern::quote).toArray(String[]::new));

        return calculatePart.split(regex);
    }

}
