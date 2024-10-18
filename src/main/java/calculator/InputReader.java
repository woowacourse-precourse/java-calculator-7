package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputReader {

    public String read() {
        String command = Console.readLine();
        Console.close();

        return command;
    }
}
