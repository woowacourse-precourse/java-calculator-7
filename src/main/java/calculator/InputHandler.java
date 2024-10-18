package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        try {
            String input = Console.readLine();

            if (isValidZero(input)) {
                return "0";
            }
            return input;
        } catch (OutOfMemoryError e) {
            throw new IllegalArgumentException("입력이 너무 큽니다.");
        }
    }

    private boolean isValidZero(String input) {
        return input == null || input.isEmpty();
    }


}