package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getInput() {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력된 문자열이 없습니다.");
        }
        return input;
    }

}
