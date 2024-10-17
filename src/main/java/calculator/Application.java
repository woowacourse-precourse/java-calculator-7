package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력하시오.");
        Scanner s = new Scanner(System.in);

        try {
            String input = s.nextLine();
            int result = Calculator.add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.err.println("에러 : " + e.getMessage());
        }
    }
}
