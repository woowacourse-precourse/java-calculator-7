package calculator;

public class StringAddCalculator {

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] tokens = splitInput(input);
        return sum(tokens);
    }

    private String[] splitInput(String input) {
        if (input.startsWith("//")) {
            return Custom(input);
        }
        return input.split("[,:]");
    }

    private static String[] Custom(String input) {

        int delimiterIndex = input.indexOf("\\n");

        if (delimiterIndex == -1) {
            throw new IllegalArgumentException("Wrong m");
        }
        String customDelimiter = input.substring(2, delimiterIndex);
        customDelimiter = customDelimiter.replace("\\", "\\\\");
        String numbers = input.substring(delimiterIndex + 2);
        return numbers.split(customDelimiter);
    }

    private int sum(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            int number = convertToInteger(token);
            if (number < 0) {
                throw new IllegalArgumentException("error");
            }
            sum += number;
        }
        return sum;
    }

    private int convertToInteger(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("error");
        }
    }

}
