package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    private String equation;

    private String readFromConsole() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        if (input == null) {
            input = "";
        }
        return input;
    }

    public void operate() {
        equation = readFromConsole();
    }
}
