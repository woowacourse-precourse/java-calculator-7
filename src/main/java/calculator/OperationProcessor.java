package calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * 연산 기능을 제공하는 클래스
 */
public class OperationProcessor {
    List<Integer> operands; // 피연산자(숫자)

    /**
     * OperationProcessor 클래스 생성자 - operands 필드 초기화
     */
    public OperationProcessor() {
        operands = new ArrayList<>();
    }

    /**
     * 덧셈 연산 수행
     */
    public int calculate(List<Integer> operands) {
        int result = 0;
        for (int operand : operands) {
            result += operand;
        }
        return result;
    }
}
