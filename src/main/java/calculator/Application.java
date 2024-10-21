package calculator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String input = scanner.nextLine();

        // 1. 입력받기 기능
        System.out.println("덧셈할 문자열을 입력해 주세요:");
        input = getInput(input);

    }

    // 1. 입력받기 기능
    private static String getInput(String input) {
        return input; // 입력된 문자열 그대로 반환
    }
}
