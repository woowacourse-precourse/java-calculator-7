package calculator.model;

public class Calculator {

    private String[] extractNumbers(String input) {
        String delimiter = "[,:]";
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("/n");
            delimiter = input.substring(2, delimiterIndex);
            input = input.substring(delimiterIndex + 1);
        }

        return input.split(delimiter);
    }
}
