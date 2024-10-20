package calculator.model;

import java.util.Arrays;

public class CalculatorModel {
    // 배열로 전달된 피연산자들을 모두 더하여 결과를 반환
    public int calculate(int[] operands) {
        return Arrays.stream(operands).sum();
    }
}
