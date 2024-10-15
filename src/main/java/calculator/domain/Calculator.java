package calculator.domain;

import java.util.List;

public class Calculator {
    //계산기가 다루는 수가 정수라 가정
    private final List<Integer> numbers;

    private Calculator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Calculator of(List<Integer> numbers) {
        //추후에 추가적인 검증 로직이 있다면 여기에 작성
        return new Calculator(numbers);
    }

    public int calculateSum() {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
