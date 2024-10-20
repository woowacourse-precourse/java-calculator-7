package calculator.domain.modal;

import java.util.List;

public abstract class Calculator {
    /**
     * 주어진 숫자 리스트에 대해 계산을 수행합니다.
     *
     * @param numbers 계산할 정수 리스트
     * @return 주어진 숫자 리스트에 대한 계산 결과
     */
    public abstract int calculate(List<Integer> numbers);
}
