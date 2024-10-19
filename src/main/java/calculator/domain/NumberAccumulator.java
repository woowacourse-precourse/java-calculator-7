package calculator.domain;

public class NumberAccumulator {
    private final SumCalculator sumCalculator;
    private String consecutiveNumbers = "";

    public NumberAccumulator(SumCalculator sumCalculator) {
        this.sumCalculator = sumCalculator;
    }

    public void appendNumber(char number) {
        consecutiveNumbers += number;
    }

    public boolean isConsecutiveNumbersEmpty() {
        return consecutiveNumbers.isEmpty();
    }

    public void flushConsecutiveNumbers() {
        if (!consecutiveNumbers.isEmpty()) {
            int parsedNumber = parsingToInteger(consecutiveNumbers);
            sumCalculator.add(parsedNumber);
            consecutiveNumbers = "";
        }
    }

    private int parsingToInteger(String number) {
        return Integer.parseInt(number);
    }
}
