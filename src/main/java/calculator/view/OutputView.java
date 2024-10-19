package calculator.view;

import java.math.BigInteger;

public class OutputView {
    public void printlnMessage(String message) {
        System.out.println(message);
    }

    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printSum(BigInteger sum) {
        System.out.printf("결과 : %s", sum);
    }
}
