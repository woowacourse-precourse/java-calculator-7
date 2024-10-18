package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String st = new Scanner(System.in).nextLine();
        int value = new Calculator().calculate(st);
        System.out.println("결과 : " + value);
    }
}
