package calculator.application.util.io.read;


import camp.nextstep.edu.missionutils.Console;

public final class InputReader {

    private InputReader() {}

    public static String read() {
        String input = Console.readLine();
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return input.trim();
    }
}
