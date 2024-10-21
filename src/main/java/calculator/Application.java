package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 1. 문자열 입력 받기
        Scanner scanner = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = scanner.nextLine();

        StringCalculator calculator = new StringCalculator();
        try {
            int result = calculator.calc(input);
            System.out.println("결과 : " + result);
        }
        catch(IllegalAccessError e) {
            System.out.println(e.getMessage());
        }
    }

}
