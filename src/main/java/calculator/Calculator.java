package calculator;

import java.util.ArrayList;

public class Calculator {

    private final String input;
    private final ArrayList<String> seperators;
    private static int sum = 0;

    public int calculate() {

        StringBuilder num = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (!seperators.contains(String.valueOf(input.charAt(i)))) {
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

    public Calculator(String input, ArrayList<String> seperators) {
        this.input = input;
        this.seperators = seperators;
    }
}
