package calculator.util;

import java.util.Scanner;

public class InputHandler {
    public static String getInput(Scanner scanner) {
        System.out.print("덧셈할 문자열을 입력해 주세요.\n");
        return scanner.nextLine();
    }
}
