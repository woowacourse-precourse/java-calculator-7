package calculator;

public class DelimiterHandler {
    public String[] extractNumbers(String input) {
        String delimiter = ",|:";
        String numbers = input;

        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf('\n');
            if (newlineIndex == -1) {
                throw new IllegalArgumentException("Invalid input format: " + input);
            }
            delimiter += "|" + input.substring(2, newlineIndex);
            numbers = input.substring(newlineIndex + 1);
        }

        return numbers.split(delimiter);
    }
}
