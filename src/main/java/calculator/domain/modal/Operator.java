package calculator.domain.modal;

import java.util.List;

public interface Operator {
    /**
     * 주어진 숫자 리스트에 대해 연산을 수행합니다.
     *
     * @param numbers 연산할 정수 리스트
     * @return 주어진 숫자 리스트에 대한 연산 결과
     */
    int operate(List<Integer> numbers);
}
