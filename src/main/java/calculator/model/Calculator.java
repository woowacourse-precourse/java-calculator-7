package calculator.model;

import java.util.List;

public class Calculator {
    public static int result = 0;
    public int sum(List<Integer> numbers) {
        for (Integer num : numbers) {
            result += num;
        }
        return result;
    }
}
