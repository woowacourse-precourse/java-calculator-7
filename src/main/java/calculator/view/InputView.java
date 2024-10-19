package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final Console console;

    public InputView(Console console) {
        this.console = console;
    }

    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return console.readLine();
    }
}
