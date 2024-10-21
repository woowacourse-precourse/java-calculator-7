package calculator.reader;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleReader implements Reader {

    @Override
    public String read() {
        String command = Console.readLine();
        Console.close();

        return command;
    }
}
