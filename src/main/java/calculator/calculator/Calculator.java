package calculator.calculator;

import java.util.List;
import java.util.function.BiFunction;

/**
 * 주어진 계산법을 동일하게 적용해서 결과값을 만들어냅니다
 */
public class Calculator {
    private final BiFunction<Integer, Integer, Integer> calculateFunction;

    /**
     * 입력받은 함수를 적용하는 계산기를 만듭니다
     * @param calculate 피연산자에 적용할 함수
     */
    public Calculator(BiFunction<Integer, Integer, Integer> calculate) {
        this.calculateFunction = calculate;
    }

    /**
     * 생성 시 입력받은 함수로 피연산자에 적용해 하나의 결과값을 반환합니다
     * @param operands 피연산자가 담긴 List
     * @param initialValue operands 가 비었을 때, 즉 연산이 없을 때 반환할 초기값
     * @return operands 의 연산 결과 혹은 initialValue
     */
    public Integer calculate(List<Integer> operands, Integer initialValue) {
        return operands.stream()
                .reduce(calculateFunction::apply).orElse(initialValue);
    }
}
