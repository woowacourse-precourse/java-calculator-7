package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = scanner.nextLine();



        System.out.println("결과: " + input);


    }
}
