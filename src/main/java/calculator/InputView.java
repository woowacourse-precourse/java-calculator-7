package calculator;

import java.util.Scanner;

public class InputView {

    public String getUserInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
