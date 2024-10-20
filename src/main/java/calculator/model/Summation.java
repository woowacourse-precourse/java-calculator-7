package calculator.model;

import java.util.List;

public class Summation {
    public int sum(List<Integer> numberArray) {
        int sum = 0;
        for (Integer number : numberArray) {
            if (number < 0) {
                throw new IllegalArgumentException("[Error] 음수는 입력할 수 없습니다.");
            }
            sum += number;
        }
        return sum;
    }
}
