package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String startCalculatorWithInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        try {
            return Console.readLine();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
