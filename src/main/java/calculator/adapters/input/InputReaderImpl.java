package calculator.adapters.input;

import calculator.application.ports.input.InputReader;
import camp.nextstep.edu.missionutils.Console;

public class InputReaderImpl implements InputReader {

    @Override
    public String readLine() {
        return Console.readLine();
    }
}
