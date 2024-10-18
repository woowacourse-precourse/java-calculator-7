package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorInput {

    public static String inputString() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();
        Console.close();
        return input;
    }
}
