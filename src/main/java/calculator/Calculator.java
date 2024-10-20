package calculator;

public class Calculator {

    static double add(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        } else if (input.isEmpty()) {
            return 0;
        } else {
            String[] tokens = tokenize(input);
            return sum(tokens);
        }
    }

    static String[] tokenize(String input) {}

    static double sum(String[] tokens) {}
}