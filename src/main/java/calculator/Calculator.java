package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    public void displayInputMessage() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public String getInput() {
        return Console.readLine();
    }

    public int add(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력 값이 null입니다.");
        }
        if (input.isEmpty()) {
            return 0;
        }

        return 0;
    }
}
