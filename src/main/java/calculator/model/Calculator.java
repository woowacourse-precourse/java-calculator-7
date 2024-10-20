package calculator.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calculator {

    private final ArrayList<String> delimiters;

    public Calculator() {
        this.delimiters = new ArrayList<>();
        this.delimiters.add(":");
        this.delimiters.add(",");
    }

    public void patchDelimeter(String customDelimiter) {
        if (!customDelimiter.isEmpty()) {
            delimiters.add(customDelimiter);
        }
    }

    public float sum(String expression) {
        List<Float> numbers = resolveNumbersFromExpression(expression);

        float sum = 0;
        for (Float num : numbers) {
            sum += num;
        }

        return sum;
    }

    private List<Float> resolveNumbersFromExpression(String expression) {
        String changedExpression = replaceDelimitersToColon(expression);

        String[] stringNumbers = changedExpression.split(":");

        List<Float> numbers = new ArrayList<>();
        for (String stringNumber : stringNumbers) {
            if (!isPositiveNumber(stringNumber)) {
                throw new IllegalArgumentException();
            }
            numbers.add(Float.parseFloat(stringNumber));
        }

        return numbers;
    }

    private String replaceDelimitersToColon(String expression) {
        List<String> subDelimiters = delimiters.subList(1, delimiters.size());
        Collections.reverse(subDelimiters);

        for (String delimiter : subDelimiters) {
            expression = expression.replace(delimiter, ":");
        }
        return expression;
    }

    private boolean isPositiveNumber(String number) {
        return number.matches("(0\\.\\d+|[1-9]\\d*(\\.\\d+)?)");
    }
}
