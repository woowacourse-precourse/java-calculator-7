package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        final String inputString = scanner.nextLine();
        return inputString;
    }
}
