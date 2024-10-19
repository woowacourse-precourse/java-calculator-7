package calculator.view;

import java.math.BigInteger;

public class Output {

    public static void printBeginningPhrase() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
    }

    public static void printResult(int result) {
        System.out.println("결과 : " + result);
    }

    public static void printResult(long result) {
        System.out.println("결과 : " + result);
    }

    public static void printResult(BigInteger result) {
        System.out.println("결과 : " + result);
    }

}
