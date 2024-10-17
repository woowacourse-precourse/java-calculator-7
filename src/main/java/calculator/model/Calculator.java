package calculator.model;

import java.util.Objects;

public class Calculator {

    private int result;

    public void calculate(String input) {
        if (Objects.equals(input, "")) {
            result = 0;
            return;
        }
        if (input.startsWith("//")) {
            String customDelimiter = String.valueOf(input.charAt(2));
            String[] numbers = input.substring(5).split(customDelimiter);
        }
    }

    public int getResult() {
        return result;
    }
}
