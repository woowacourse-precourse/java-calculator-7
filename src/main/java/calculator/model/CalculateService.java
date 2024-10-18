package calculator.model;

import java.util.List;

public class CalculateService {
    public Integer calculateNumbers(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}
