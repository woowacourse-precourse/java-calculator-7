package calculator.domain;

public class Calculator {

    public int splitAndSum(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        if (input.startsWith("//")) {
            String[] customSplit = input.split("\n", 2);
            String customDelimiter = customSplit[0].substring(2);
            return sumNumbers(customSplit[1].split(customDelimiter + "|,|:"));
        }

        return sumNumbers(input.split(",|:"));
    }

    private int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
