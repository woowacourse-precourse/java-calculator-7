package calculator;

import java.util.*;

public class Calculator {
    private final List<String> numbers;

    public Calculator(List<String> numbers) {
        this.numbers = numbers;
    }

    public String sum() {
        float result = 0;
        for (String number : numbers) {
            result += Float.parseFloat(number);
        }
        if (result == (int) result) {
            return String.format("%.0f", result);
        } else {
            return String.format("%s", result);
        }
    }
}
