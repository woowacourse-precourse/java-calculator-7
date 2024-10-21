package calculator.view;

import java.util.Scanner;

public class InputView {

    public static final Scanner scanner = new Scanner(System.in);

    public static String readInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return scanner.nextLine();
    }
}
