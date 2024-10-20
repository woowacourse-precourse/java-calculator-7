package calculator.service;

import java.util.List;

public class CalculatorService {
    // 정수 합 계산
    public int sum(List<Integer> numberInputs) {
        return numberInputs.stream().mapToInt(Integer::intValue).sum();
    }
}
