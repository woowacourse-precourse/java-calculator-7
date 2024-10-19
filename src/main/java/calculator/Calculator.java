package calculator;

import java.util.Scanner;

public class Calculator {
    Scanner scanner;
    String input;

    Calculator() {
        scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        input = scanner.next();
    }
}
