package calculator.domain.modal;

import java.util.List;

public class ArithmeticCalculator extends Calculator {
    private final Operator operator;

    public ArithmeticCalculator(Operator operator) {
        this.operator = operator;
    }

    /**
     * 주어진 숫자 리스트에 대해 연산자를 사용하여 계산을 수행합니다.
     *
     * @param numbers 계산할 정수 리스트
     * @return 주어진 숫자 리스트에 대한 연산 결과
     */
    @Override
    public int calculate(List<Integer> numbers) {
        return operator.operate(numbers);
    }
}
