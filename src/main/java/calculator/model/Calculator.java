package calculator.model;

import calculator.utils.StringParser;

public class Calculator {
    public int add(String input) {
        String[] numbers = StringParser.parse(input);
        int sum = 0;

        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }
}
