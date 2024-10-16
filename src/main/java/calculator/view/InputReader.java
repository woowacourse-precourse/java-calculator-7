package calculator.view;

import java.util.Scanner;

public class InputReader {

    private Scanner scanner;

    public InputReader() {
        this.scanner = new Scanner(System.in);
    }

    public String readLine() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = scanner.nextLine();
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        return input;
    }

}