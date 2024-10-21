package calculator;

import java.util.Scanner;

public class InputHandler {
    public static String getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = scanner.nextLine();
        scanner.close();
        return input;
    }
}
