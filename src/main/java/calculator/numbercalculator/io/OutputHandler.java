package calculator.numbercalculator.io;

import java.math.BigInteger;

public class OutputHandler {

    public void showAdditionComment() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public void showCalculateResult(BigInteger result) {
        System.out.printf("결과 : %d", result);
    }
}
