package calculator.view;

import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return scanner.nextLine();
    }

}
