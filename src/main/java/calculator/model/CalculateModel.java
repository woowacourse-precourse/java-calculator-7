package calculator.model;


import java.util.ArrayList;
import java.util.List;

public class CalculateModel {

    // 피연산자 배열
    private List<Integer> operators = new ArrayList<>();

    public void setOperators(List<Integer> operators) {
        this.operators = operators;
    }

    // 최종 덧셈 연산 메서드
    public int calculate(List<Integer> operators) {
        int sum = 0;

        for (int i = 0; i < operators.size(); i++) {
            sum += operators.get(i);
        }

        return sum;
    }
}
