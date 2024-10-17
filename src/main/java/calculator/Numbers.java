package calculator;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private List<Double> numbers;
    public Numbers(List<Double> numbers) {
        validateNegative(numbers);
        this.numbers = numbers;
    }

    private void validateNegative(List<Double> numbers) {
        for (Double number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException("[ERROR] 양의 정수를 입력해주세요");
            }
        }
    }

    public Double getSum() {
        Double sum = 0.0;
        for (Double number : numbers) {
            sum += number;
        }
        return sum;
    }
}
