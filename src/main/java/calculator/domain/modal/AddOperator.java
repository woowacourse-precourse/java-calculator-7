package calculator.domain.modal;

import java.util.List;

public class AddOperator implements Operator {

    /**
     * 주어진 숫자 리스트의 합을 계산합니다.
     *
     * @param numbers 합을 계산할 정수 리스트
     * @return 주어진 숫자 리스트의 합
     */
    @Override
    public int operate(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
