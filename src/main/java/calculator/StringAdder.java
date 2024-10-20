package calculator;

import java.util.regex.Pattern;

public class StringAdder {

    private int findDelimiterEndIndex(String input) {
        if (input.startsWith("//") && input.contains("\\n")) {
            return input.indexOf("\\n");
        }
        return -1;
    }

    private String extractDelimiter(String input) {
        String delimiter = ",|:";
        int delimiterEndIndex = findDelimiterEndIndex(input);
        if (delimiterEndIndex != -1) {
            delimiter = input.substring(2, delimiterEndIndex);
            InputValidator.delimiterValidate(delimiter);
        }
        return delimiter;
    }

    private String removeDelimiterSection(String input) {
        int delimiterEndIndex = findDelimiterEndIndex(input);
        if (delimiterEndIndex != -1) {
            return input.substring(delimiterEndIndex + 2);
        }
        return input;
    }

    private String[] splitNumbers(String input, String delimiter) {
        String[] inputArray;
        if (delimiter.equals(",|:")) {
            inputArray = input.split(delimiter);
        } else {
            inputArray = input.split(Pattern.quote(delimiter));
        }

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i].equals("")) {
                inputArray[i] = "0";
            }
        }
        return inputArray;
    }

    private int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum = Math.addExact(sum, Integer.parseInt(number));
        }
        return sum;
    }

    public int add(String input) {
        if (InputValidator.isNullInput(input)) {
            return 0;
        }

        String delimiter = extractDelimiter(input);
        input = removeDelimiterSection(input);

        String[] numbers = splitNumbers(input, delimiter);

        InputValidator.validate(numbers);

        return sumNumbers(numbers);
    }
}
