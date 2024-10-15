package calculator;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private List<Integer> numbers;
    public Numbers(List<Integer> numbers) {
        validateNegative(numbers);
        this.numbers = numbers;
    }

    private void validateNegative(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException("[ERROR] 양의 정수를 입력해주세요");
            }
        }
    }

    public int getSum() {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}
