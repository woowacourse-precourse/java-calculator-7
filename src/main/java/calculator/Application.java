package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner sc = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = sc.nextLine();

        try {
            int result = calculate(input);
            System.out.println("결과 : " + result);
        }
        catch (IllegalArgumentException e){
            System.out.println("잘못된 입력입니다." + e.getMessage());
        }
    }
    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

    }
}
