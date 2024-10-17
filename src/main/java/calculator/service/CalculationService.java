package calculator.service;

import java.util.Arrays;

public class CalculationService {

    public int calculate(int[] numbers) {
        //TODO: 계산 로직 구현
        return Arrays.stream(numbers).sum();
    }
}
