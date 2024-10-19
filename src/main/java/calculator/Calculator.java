package calculator;

import java.util.ArrayList;

public class Calculator {

    private final String input;
    private final ArrayList<Character> separators;
    private int sum = 0;

    public int calculate() {

        StringBuilder num = new StringBuilder();

        int index = 0;

        if (input.startsWith("//")) {
            index = 5;
        }

        for (int i = index; i < input.length(); i++) {
            if (!separators.contains(input.charAt(i))) {
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

    public Calculator(String input, ArrayList<Character> separators) {
        this.input = input;
        this.separators = separators;
    }
}
