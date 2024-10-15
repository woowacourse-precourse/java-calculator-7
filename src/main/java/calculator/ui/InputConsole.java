package calculator.ui;

import camp.nextstep.edu.missionutils.Console;

class InputConsole implements InputUi {

    public String readLine() {
        return Console.readLine();
    }
}
