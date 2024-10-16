package calculator.View;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public String readInputString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();
        hasValue(input);
        return input;
    }

    public void hasValue(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("값을 입력해야 합니다.");
        }
    }
}
