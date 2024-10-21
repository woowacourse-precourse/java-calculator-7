package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;
import java.util.NoSuchElementException;

public class CalculatorView {

public String getInput() {
    System.out.println("덧셈할 문자열을 입력해 주세요.");
    try {
        return Console.readLine();
    } catch (NoSuchElementException e) {
        return "";
    }
}
    
    public void displayResult(BigInteger result) {
        System.out.println("결과 : " + result);
    }

    public void displayError(String message) {
        System.err.println(message);
    }
}