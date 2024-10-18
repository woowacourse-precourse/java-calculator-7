package calculator.domain.handler;

import calculator.domain.view.InputView;
import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    private final InputView inputView;

    public InputHandler() {
        this.inputView = new InputView();
    }

    /**
     * 사용자로부터 입력을 받습니다.
     *
     * @return 입력된 문자열
     */
    public String getInput() {
        inputView.inputMessage();
        return Console.readLine();
    }
}
