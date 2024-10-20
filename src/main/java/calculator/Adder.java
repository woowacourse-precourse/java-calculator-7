package calculator;

import java.util.List;

public class Adder {
    private final List<Integer> numList;

    public Adder(List<Integer> numList) {
        this.numList = numList;
    }

    // 추출된 모든 숫자를 합산하여 반환
    public int addAll() {
        int sum = 0;
        for(int number : numList) {
            sum += number;
        }

        return sum;
    }
}
