package calculator.model;

import java.util.ArrayList;
import java.util.List;

// 덧셈 계산기 정의
public class Calculator {

    private final List<Integer> numbers;

    public Calculator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Integer CalcSum() {
        int sum = 0;
        for(Integer number : numbers) {
            sum += number;
        }
        return sum;
    }

}
