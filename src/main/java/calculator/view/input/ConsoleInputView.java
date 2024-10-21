package calculator.view.input;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView {
    @Override
    public String readInput() {
        return Console.readLine();
    }
}
