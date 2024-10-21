package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    private String inputValue;
    private Integer result = 0;

    Calculator() {
    }

    public void createInputValue() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        this.inputValue = Console.readLine();
    }
}
