package calculator.model;

import java.util.List;

public class Calculator {
    public int sum(List<Integer> numbers) {
        int result = 0;
        for (Integer num : numbers) {
            result += num;
        }
        return result;
    }
}
