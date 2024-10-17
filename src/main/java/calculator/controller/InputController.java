package calculator.controller;

import calculator.view.InputView;
import camp.nextstep.edu.missionutils.Console;

public class InputController {
    private InputView inputView = new InputView();

    // 문자열을 입력받음
    public String getInputString() {
        // 문자열 입력을 위한 안내문장 출력
        inputView.printMessage();

        return Console.readLine();
    }
}
