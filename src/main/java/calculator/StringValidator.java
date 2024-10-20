package calculator;

public class StringValidator {
    private static final String DEFAULT_DELIMITER = ",|:";

    public String validateAndProcess(String input) {
        if (isEmpty(input)) {
            return "결과 : 0";
        }

        String delimiter = DEFAULT_DELIMITER;
        String numbersString = input;

        if (isCustomDelimiter(input)) {
            delimiter = extractCustomDelimiter(input);
            numbersString = extractNumbersString(input);
        }

        int sum = calculateSum(numbersString, delimiter);
        return "결과 : " + sum;
    }

    private boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private boolean isCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    private String extractCustomDelimiter(String input) {
        int delimiterEnd = input.indexOf("\n");
        if (delimiterEnd == -1) {
            delimiterEnd = input.indexOf("\\n");
            if (delimiterEnd == -1) {
                throw new IllegalArgumentException();
            }
        }
        return input.substring(2, delimiterEnd);
    }

    private String extractNumbersString(String input) {
        int numbersStart = input.indexOf("\n");
        if (numbersStart == -1) {
            numbersStart = input.indexOf("\\n");
            if (numbersStart == -1) {
                throw new IllegalArgumentException();
            }
            numbersStart += 2;
        } else {
            numbersStart += 1;
        }
        return input.substring(numbersStart);
    }

    private int calculateSum(String input, String delimiter) {
        String[] numbers = input.split(delimiter);
        int sum = 0;
        for (String number : numbers) {
            if (!number.trim().isEmpty()) {
                sum += parsePositiveInt(number.trim());
            }
        }
        return sum;
    }

    private int parsePositiveInt(String number) {
        try {
            int value = Integer.parseInt(number);
            if (value < 0) {
                throw new IllegalArgumentException();
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}