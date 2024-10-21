package calculator.view;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getInput() {
        try {
            return scanner.nextLine();
        } catch (NoSuchElementException e) {
            //System.err.println("입력이 없거나 더 이상 읽을 수 없습니다.");
            return null; // null을 반환
        }
    }

}
