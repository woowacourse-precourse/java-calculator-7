package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public String getInput() {
        String input = Console.readLine();

        if (input == null || isInputBlank(input)) {
            throw new IllegalArgumentException("띄어쓰기를 포함시킬 수 없습니다.");
        }

        return input;
    }

    private boolean isInputBlank(String input) {
        return input != null && !input.equals(" ");
    }

}
