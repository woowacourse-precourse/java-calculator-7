package calculator;

import java.util.Scanner;

public class Application {

    public static void getUserInput() {
        String userInput;
        Scanner scanner = new Scanner(System.in);
        userInput = scanner.nextLine();
        System.out.println(userInput);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해주세요");
        getUserInput();
    }
}
