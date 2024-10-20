package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;

/**
 * 사용자에게 결과를 콘솔에 보여주는 view
 */
public class OutputView {
    public void displayResult(BigInteger result) {
        System.out.println("결과 : " + result);
        Console.close();
    }

    public void displayResultZero() {
        System.out.println("결과 : 0");
        Console.close();
    }
}
