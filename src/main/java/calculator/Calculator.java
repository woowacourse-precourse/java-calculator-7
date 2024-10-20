package calculator;

public class Calculator {

    static double add(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        } else if (input.isEmpty()) {
            return 0;
        }
    }
}