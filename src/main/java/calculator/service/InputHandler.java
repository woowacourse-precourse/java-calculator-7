package calculator.service;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public String getUserInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.\n");

        String input = Console.readLine();

        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("사용자의 입력이 비어있습니다.");
        }

        return input;
    }

    public void validateInput(String input) {
        String regex = "^[0-9,]+$";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException("구분자와 양수로 구성된 입력이 아닙니다.");
        }
    }
}
