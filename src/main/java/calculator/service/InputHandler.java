package calculator.service;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public String getUserInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        return Console.readLine();
    }

    public void validateInput(String input) {
        String regex = "^[0-9]+(,[0-9]+)*$";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException("올바른 입력이 아닙니다.");
        }
    }
}
