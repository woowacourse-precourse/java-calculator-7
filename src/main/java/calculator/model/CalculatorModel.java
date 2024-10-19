package calculator.model;

import calculator.Validator.Validator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class CalculatorModel {

    private List<Integer> numbers;

    public void processInput(String input) throws IllegalArgumentException {
        List<String> parsedStrings = parseUserInput(input);
        Validator.validateParsedStrings(parsedStrings);

        List<Integer> parsedNumbers = stringsToIntegers(parsedStrings);
        Validator.validatePositiveNumbers(parsedNumbers);

        this.numbers = parsedNumbers;
    }

    public boolean isCustom(String input) {
        return input.startsWith("//") && input.contains("\\n");
    }

    public List<String> parseUserInput(String input) {
        if (isCustom(input)) {
            return parseCustomString(input);
        }

        return parseDefaultString(input);
    }

    public List<String> parseCustomString(String input) {
        int delimiterEndIndex = input.indexOf("\\n");
        String delimiter = input.substring(2, delimiterEndIndex);
        String numbersPart = input.substring(delimiterEndIndex + 2);

        return Arrays.asList(numbersPart.split(delimiter));
    }

    public List<String> parseDefaultString(String input) {
        return Arrays.asList(input.split("[,;]"));
    }

    public List<Integer> stringsToIntegers(List<String> parsedStrings) {
        List<Integer> parsedInteger = new ArrayList<>();

        for (String str : parsedStrings) {
            if (str.isBlank()) {
                continue;
            }

            parsedInteger.add(Integer.parseInt(str));
        }

        return parsedInteger;
    }

    public int calculateSum() {
        int sum = 0;

        for (int n : this.numbers) {
            sum += n;
        }

        return sum;
    }
}
