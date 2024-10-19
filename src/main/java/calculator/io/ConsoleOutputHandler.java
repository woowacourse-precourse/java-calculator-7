package calculator.io;

import java.math.BigInteger;

public class ConsoleOutputHandler {

    public void showInputComments(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public void showFinalOutput(BigInteger sum) {
        System.out.println("결과 : " + sum);
    }
}
