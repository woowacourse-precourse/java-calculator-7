package calculator.view;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;

public class CalculatorView {

    public void printStartMsg() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public String getUserInput() {
        return Console.readLine();
    }

    public void printResultMsg(BigInteger result) {
        System.out.printf("결과 : %d", result);
    }
}
