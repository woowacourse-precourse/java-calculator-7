package calculator.model;

import java.util.List;

public class Calculator {

    private final Operator operator;

    public Calculator(){
        this.operator = new AddOperator();
    }

    /**
     * 숫자 리스트에서 계산을 해주는 메서드
     * @param numberList 숫자 리스트
     * @return 계산된 값
     */
    public int add(List<Integer> numberList){
        return operator.operate(numberList);
    }
}
