package calculator;

import java.util.Scanner;

public class CalculatorInputHandler {
    private final Scanner scanner;

    public CalculatorInputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public String input() {
        printMessage();
        return scanMessage();
    }

    private void printMessage() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    private String scanMessage() {
        String input = scanner.nextLine();
        scanner.close();
        return input;
    }
}
