package calculator;

import java.util.Scanner;

public class Calculator {

    public static String get_input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return sc.nextLine();
    }

}
