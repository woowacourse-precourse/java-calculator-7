package calculator.ui;

import camp.nextstep.edu.missionutils.Console;

class InputConsole implements InputUi {

    @Override
    public String readLine() {
        return Console.readLine();
    }
}
