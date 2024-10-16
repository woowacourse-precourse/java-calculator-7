package calculator;

import java.util.List;

/**
 * - 숫자를 더하는 클래스
 * - 작성을 하면서 생각해봤는데, 확장성을 고려하였을 때에는 연산문자를 가지고 와서 변환하는 게 좋을 것 같음
 * - 만약 덧셈이 아니라 뺄셈 혹은 곱셈이 들어간다고 가정하면 그에 대한 구분자가 들어가야 함
 */
public class Adder {
    private final Integer sum;
    private final List<Integer> numbers;

    public Adder(Classifier classifier) {
        this.numbers = classifier.getNumbers();
        this.sum = calculate();
    }


    public Integer calculate() {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public String toString() {
        return "결과: " + sum;
    }
}
