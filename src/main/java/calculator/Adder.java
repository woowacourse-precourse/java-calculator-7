package calculator;

import java.util.List;

/**
 * 주어진 숫자 리스트의 합계를 계산하는 클래스입니다.
 */
public class Adder {

    /**
     * 정수 리스트의 합 계산
     */
    public int sum(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
