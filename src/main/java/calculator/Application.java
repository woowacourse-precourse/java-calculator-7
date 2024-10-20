package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = readInput();

        Calculator calculator = new Calculator();
        long result = calculator.calculate(input);
    }

    private static String readInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {  //입력이 없는 경우
            return "";
        }
    }
}
