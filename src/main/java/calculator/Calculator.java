package calculator;

import java.util.*;

public class Calculator {
    private final List<String> numbers;

    public Calculator(List<String> numbers) {
        this.numbers = numbers;
    }

    public int sum() {
        int result = 0;
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }
        return result;
    }
}
