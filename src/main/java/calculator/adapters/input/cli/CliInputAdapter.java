package calculator.adapters.input.cli;

import calculator.ports.input.InputPort;
import camp.nextstep.edu.missionutils.Console;

public class CliInputAdapter implements InputPort {

    @Override
    public String readLine() {
        return Console.readLine();
    }
}
