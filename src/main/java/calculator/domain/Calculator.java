package calculator.domain;

import java.util.List;

public class Calculator {
    public int sum(List<String> numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
