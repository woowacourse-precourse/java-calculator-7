package calculator.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView(final Scanner scanner) {
        this.scanner = scanner;
    }

    public String receiveValue() {
        System.out.println("덧셈할 문자열을 입력해 주세요. Ex)1,2,3 ");
        return scanner.next();
    }

}
