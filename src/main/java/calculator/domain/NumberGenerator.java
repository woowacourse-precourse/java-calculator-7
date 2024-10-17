package calculator.domain;

public class NumberGenerator {
    private final SumCalculator sumCalculator;
    private String consecutiveNumbers = "";

    public NumberGenerator(SumCalculator sumCalculator) {
        this.sumCalculator = sumCalculator;
    }

    public void generator(char number) {
        consecutiveNumbers += number;
    }

    public void isDelimiter(boolean flag) {
        if (flag && !consecutiveNumbers.isEmpty()) {
            flushConsecutiveNumbers();
        }
    }

    public void flushConsecutiveNumbers() {
        if (!consecutiveNumbers.isEmpty()) {
            int parsedNumber = parsingToInteger(consecutiveNumbers);
            sumCalculator.sum(parsedNumber);
            consecutiveNumbers = "";
        }
    }

    private int parsingToInteger(String number) {
        return Integer.parseInt(number);
    }
}
