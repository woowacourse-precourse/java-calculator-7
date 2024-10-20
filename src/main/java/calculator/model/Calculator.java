package calculator.model;

import calculator.utils.StringParser;

public class Calculator {
    public int add(String input) {
        StringParser parser = new StringParser();
        int[] numbers = parser.parse(input);
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
