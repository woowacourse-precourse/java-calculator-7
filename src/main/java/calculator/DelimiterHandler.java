package calculator;

import java.util.Arrays;

public class DelimiterHandler {
    public String[] splitNumbers(String input) {
        String delimiter = ",|:";
        String numbers = input;

        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\\n");
            System.out.println(newlineIndex);
            if (newlineIndex == -1 || newlineIndex <= 2) {
                throw new IllegalArgumentException("Invalid input format: " + input);
            }
            delimiter += "|" + input.substring(2, newlineIndex);
            numbers = input.substring(newlineIndex + 2);
        }

        return numbers.split(delimiter);
    }
}
