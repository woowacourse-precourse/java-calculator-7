package calculator.ui;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_SENTENCE = "덧셈할 문자열을 입력해 주세요.";
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputView() {
        System.out.println(INPUT_SENTENCE);
        return scanner.nextLine();
    }
}
