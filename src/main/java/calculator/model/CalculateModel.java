package calculator.model;


import java.util.List;

public class CalculateModel {

    // 최종 덧셈 연산 메서드
    public int sum(List<Integer> operands) {
        int sum = 0;

        for (int i = 0; i < operands.size(); i++) {
            sum += operands.get(i);
        }
        return sum;
    }
}
