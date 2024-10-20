package calculator.io;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputReceiver implements InputReceiver {
    @Override
    public String readInput() {
        return Console.readLine();
    }
}
