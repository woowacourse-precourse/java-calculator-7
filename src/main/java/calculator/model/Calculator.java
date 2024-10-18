package calculator.model;

import java.util.ArrayList;

public class Calculator {

    private ArrayList<String> delimiters;

    public Calculator() {
        this.delimiters = new ArrayList<>();
        this.delimiters.add(",");
        this.delimiters.add(":");
    }

    public void patchDelimeter(String customDelimiter) {
        if (!customDelimiter.isEmpty()) {
            delimiters.add(customDelimiter);
        }
    }

    public int sum(String expression) {
        String regex = String.join("|", delimiters);
        String[] numbers = expression.split(regex);

        int sum = 0;
        for (String number : numbers) {
            if (!isPositiveNumber(number)) {
                throw new IllegalArgumentException();
            }
            sum += Integer.parseInt(number);
        }

        return sum;
    }

    private boolean isPositiveNumber(String number) {
        return number.matches("[1-9]\\d*");
    }
}
