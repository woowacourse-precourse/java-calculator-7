package calculator;

import java.util.List;

public class CalculatorService {

    public int calculate(String expression, List<String> separators) {
        String[] splitExpression = expression.split(String.join("|", separators));

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
