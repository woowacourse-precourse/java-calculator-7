package calculator;

public class StringCalculator {
    private final DelimiterParser delimiterParser;
    private final NumberParser numberParser;

    public StringCalculator() {
        this.delimiterParser = new DelimiterParser();
        this.numberParser = new NumberParser();
    }

    public int addNumbers(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String numberString = numbers;
        String delimiter = delimiterParser.parse(numbers);

        int sum = 0;
        String[] splitNumbers = splitNumbers(numberString, delimiter);

        for (String splitNum : splitNumbers) {
            int number = numberParser.parse(splitNum);
            sum += number;
        }
        return sum;
    }

    private String[] splitNumbers(String numberString, String delimiter) {
        return numberString.split(delimiter);
    }
}
