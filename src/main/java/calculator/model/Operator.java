package calculator.model;

import java.util.List;

public interface Operator {

    /**
     * 숫자 리스트에서 계산을 해주는 메서드
     * @param numberList 숫자 리스트
     * @return 계산된 값
     */
    public int operate(List<Integer> numberList);
}
