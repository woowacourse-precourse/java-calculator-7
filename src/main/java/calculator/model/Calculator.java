package calculator.model;

public class Calculator {
    private final StringSplitter stringSplitter;

    public Calculator(StringSplitter stringSplitter) {
        this.stringSplitter = stringSplitter;
    }

    public int add(String input) {
        String[] numbers = stringSplitter.split(input);
        return sum(numbers);
    }

    private int sum(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            int parsedNumber = parseNumber(number);
            if (parsedNumber < 0) {
                throw new IllegalArgumentException();
            }
            total += parsedNumber;
        }
        return total;
    }

    private int parseNumber(String str) {
        if (!str.matches("[0-9]+")) {
            throw new IllegalArgumentException();
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}