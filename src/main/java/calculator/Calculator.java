package calculator;

public class Calculator {
    private final StringSpliter splitter;

    public Calculator(StringSpliter splitter) {
        this.splitter = splitter;
    }

    public int calculate(String input) {
        String[] splitValues = splitter.split(input);
        int sum = 0;
        for (String value : splitValues) {
            if (!isPositiveInteger(value)) {
                throw new IllegalArgumentException();
            }
            sum += Integer.parseInt(value);
        }
        return sum;
    }

    private boolean isPositiveInteger(String s) {
        try {
            int number = Integer.parseInt(s);
            return number > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
