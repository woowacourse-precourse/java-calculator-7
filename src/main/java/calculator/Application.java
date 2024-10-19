package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        try {
            String s = Console.readLine();
            int result = StringAddCalculator.calculator(s);
            System.out.println("결과 : " + result);
        } catch (NoSuchElementException e) {
            System.out.println("결과 : 0");
        }
    }
}
