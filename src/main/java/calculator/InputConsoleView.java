package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputConsoleView implements InputView {

    @Override
    public String inputValue() {
        return Console.readLine();
    }
}
