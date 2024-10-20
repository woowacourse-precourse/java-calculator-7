package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;

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
