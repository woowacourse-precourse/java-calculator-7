package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public String getInput() {
        String input = Console.readLine();
        checkValidation(input);
        return input;
    }

    private void checkValidation(String input) {
        if (!input.startsWith("/") && !Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException("문자의 시작이 / 또는 숫자가 아닙니다.");
        }
    }
}
