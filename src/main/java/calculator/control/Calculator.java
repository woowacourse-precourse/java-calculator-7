package calculator.control;

import java.util.List;

public class Calculator {
    public int addNumbers(List<Integer> numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }
}
