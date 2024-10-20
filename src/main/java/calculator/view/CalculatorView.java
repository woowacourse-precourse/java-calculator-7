package calculator.view;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;

public class CalculatorView {
    //TODO: 사용자로부터 입력을 받고, 계산한 뒤의 출력을 담당하는 클래스

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
