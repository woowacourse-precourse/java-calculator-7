package calculator;

import java.util.Scanner;

public class Application {

    private static int Calculator(String st){
        int result = 0;


        return result;
    }

    public static void main(String[] args) {
        // 프로그램 구현
        Scanner sc = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = sc.nextLine();

        int answer = Calculator(input);
        System.out.printf("결과 : %d", answer);
    }
}
