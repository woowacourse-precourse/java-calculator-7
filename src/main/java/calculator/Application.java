package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        app.start();
    }

    private void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("덧셈할 문자열을 입력해 주세요: ");
        String input = scanner.nextLine();

        scanner.close();
    }
}