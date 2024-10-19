package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;

public class CalculatorView {

    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }
    
    public void displayResult(BigInteger result) {
        System.out.println("결과 : " + result);
    }

    public void displayError(String message) {
        System.err.println(message);
    }
}