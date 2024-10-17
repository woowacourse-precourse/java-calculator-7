package calculator;

import java.util.ArrayList;
import java.util.Arrays;

public class Calculator {
    private final String input;

    public Calculator(String input) {
        this.input = input;
    }

    public void run() {
        if (isEmpty(input)) {
            System.out.println("결과 : 0");
            return;
        }

        ArrayList<String> values = splitToArrayList(input);
        InputValidator validator = new InputValidator();
        validator.validate(values);

        int result = sumOfNumbers(values);
        System.out.println("결과 : " + result);
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private ArrayList<String> splitToArrayList(String input) {
        StringBuilder delimiter = new StringBuilder(",|;");
        String numbers = input;

        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\\n");
            numbers = input.substring(delimiterEndIndex + 2);

            for (int i = 2; i < delimiterEndIndex; i++) {
                delimiter.append("|").append(input.charAt(i));
            }
        }

        String[] splitValues = numbers.split(delimiter.toString());
        return new ArrayList<>(Arrays.asList(splitValues));
    }

    private int sumOfNumbers(ArrayList<String> values) {
        int sum = 0;
        for (String value : values) {
            sum += Integer.parseInt(value);
        }
        return sum;
    }
}
