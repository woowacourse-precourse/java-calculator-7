package calculator;

import java.util.*;

public class Calculator {
    Scanner scanner;

    Calculator(){
        scanner = new Scanner(System.in);
    }

    public void run(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = scanner.next();
    }
}
