package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView {

    @Override
    public String readLine() {
        return Console.readLine();
    }
}
