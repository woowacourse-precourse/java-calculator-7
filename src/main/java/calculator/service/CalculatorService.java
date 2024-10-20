package calculator.service;

import java.util.List;

public class CalculatorService {
    // 정수 합 계산
    public int calculate(List<Integer> numberInputs) {
        return numberInputs.stream().mapToInt(Integer::intValue).sum();
    }
}
