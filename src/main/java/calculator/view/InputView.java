package calculator.view;

import calculator.util.io.IOConsole;

public class InputView {

    public String readUserInput() {
        IOConsole.println("덧셈할 문자열을 입력해 주세요.");
        return IOConsole.readLine();
    }
}
