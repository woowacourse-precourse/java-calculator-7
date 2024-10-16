package calculator;

import calculator.domain.Calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        try {
            promptUserForInput();
            String input = getInput();

            int result = Calculator.performAddition(input);
            System.out.println("결과 : " + result);

            System.out.println();

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }

    }

    private static void promptUserForInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    private static String getInput() {
        return Console.readLine();
    }

}
