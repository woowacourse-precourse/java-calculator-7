package calculator.model;

public class NumberAdder {
    private static final int DEFAULT_RESULT = 0;
    private final NumberParser numberParser;

    public NumberAdder(String input) {
        this.numberParser = new NumberParser(input);
    }

    public int calculate() {
        int sum = DEFAULT_RESULT;
        for (Number n : numberParser.getNumbers()) {
            sum += n.getNumber();
        }
        return sum;
    }
}
