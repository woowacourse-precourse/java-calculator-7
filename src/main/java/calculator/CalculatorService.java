package calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorService {
    private static final List<String> DEFAULT_SEPARATOR = List.of(":", ",");
    private static final String DOUBLE_BACKSLASH_DELIMITER = "\\\\";
    private static final String BACKSLASH_DELIMITER = "\\";

    private final List<String> separators;

    public CalculatorService() {
        separators = new ArrayList<>(DEFAULT_SEPARATOR);
    }

    public void addSeparator(String newSeparator) {
        if(!separators.contains(newSeparator)) {
            if (newSeparator.equals(BACKSLASH_DELIMITER)) {
                separators.add(DOUBLE_BACKSLASH_DELIMITER);
            } else {
                separators.add(newSeparator);
            }
        }
    }

    public int calculate(String expression) {
        String[] splitExpression = expression.split(separators.toString());
        int result = 0;
        for (String number : splitExpression) {
            int numberInt = Integer.parseInt(number);
            checkNumberIsPositive(numberInt);
            result += numberInt;
        }
        return result;
    }

    private void checkNumberIsPositive(int numberInt) {
        if (numberInt <= 0) {
            throw new IllegalArgumentException("Not a positive number: " + numberInt);
        }
    }
}
