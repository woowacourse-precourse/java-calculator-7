package calculator.application.util.io.read;


import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public final class InputReader {

    private InputReader() {}

    public static String read() {
        try {
            String input = Console.readLine();
            InputValidator.validateNullAndEmpty(input);
            Console.close();
            return input.trim();
        } catch (NoSuchElementException exception) {
            throw new IllegalArgumentException();
        }
    }

}
