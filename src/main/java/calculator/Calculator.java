package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    public void calculate() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        try {
            Input input = new Input(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
