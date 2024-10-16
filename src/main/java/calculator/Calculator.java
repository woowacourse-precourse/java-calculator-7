package calculator;

import java.util.Scanner;

public class Calculator {
    public void start() {
        final String START_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
        System.out.println(START_MESSAGE);
        work();
    }

    private void work() {
        String input = inputString();
//        System.out.println(input);
        printResult();
    }

    private String inputString() {
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    private void printResult() {
    }
}