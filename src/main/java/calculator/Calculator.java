package calculator;

import java.util.ArrayList;

public class Calculator {

    private final String input;
    private final ArrayList<String> separators;
    private static int sum = 0;

    public int calculate() {

        StringBuilder num = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (!separators.contains(String.valueOf(input.charAt(i)))) {
                num.append(input.charAt(i));
            } else {
                sum += Integer.parseInt(num.toString());
                num = new StringBuilder();
            }
        }

        if (!num.isEmpty()) {
            sum += Integer.parseInt(num.toString());
        }

        return sum;
    }

    public Calculator(String input, ArrayList<String> separators) {
        this.input = input;
        this.separators = separators;
    }
}
