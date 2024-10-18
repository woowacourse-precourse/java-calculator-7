package calculator;

import java.util.Scanner;

public class Calculator {
    void start() {
        final String START_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
        System.out.println(START_MESSAGE);
        work();
    }

    private void work() {
        String input = inputString();
        printResult(0);
    }

    private String inputString() {
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    private void printResult(int result) {
        System.out.println("결과 : " + result);
    }
}