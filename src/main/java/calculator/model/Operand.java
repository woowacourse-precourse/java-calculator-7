package calculator.model;

public class Operand {
    private final int[] numbers;

    private Operand(String delimiter, String expression) {
        if (expression.matches("^([" + delimiter + "]+).*") || expression.matches(".*([" + delimiter + "]+)$")) {
            throw new IllegalArgumentException("Input cannot start or end with a delimiter.");
        }
        if (expression.matches(".*([" + delimiter + "]{2,}).*")) {
            throw new IllegalArgumentException("Consecutive delimiters are not allowed.");
        }
        if (!delimiter.contains("-") && expression.contains("-")) {
            throw new IllegalArgumentException("Negative numbers are not allowed");
        }

        String[] numbers = expression.split(delimiter);
        this.numbers = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            this.numbers[i] = Integer.parseInt(numbers[i]);
        }
    }

    public static Operand create(String delimiter, String expression) {
        return new Operand(delimiter, expression);
    }

    public int[] getNumbers() {
        return numbers;
    }
}
