package calculator.operator;

import calculator.Classifier;

import java.util.List;

/**
 * - 역할: 숫자의 합을 구한다.
 * - 책임: 숫자 연산을 제대로 수행한다.
 */
public class Adder extends Operator {
    private final Integer result;
    private final List<Integer> numbers;

    public Adder(Classifier classifier) {
        this.numbers = classifier.getNumbers();
        this.result = calculate().intValue();
    }


    public Double calculate() {
        return numbers.stream().mapToDouble(Integer::doubleValue).sum();
    }

    @Override
    public String toString() {
        return "결과 : " + result;
    }
}
