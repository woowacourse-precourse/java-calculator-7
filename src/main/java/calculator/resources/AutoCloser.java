package calculator.resources;

import camp.nextstep.edu.missionutils.Console;

public class AutoCloser implements AutoCloseable {
    @Override
    public void close() throws Exception {
        Console.close();
    }
}
