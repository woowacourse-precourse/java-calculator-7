package calculator.domain.console.util;

import static calculator.global.exception.ErrorMessage.EMPTY_INPUT;

import camp.nextstep.edu.missionutils.Console;

public final class ConsoleReader {

    public static String read() {
        return validateBlankInput(Console.readLine());
    }

    private static String validateBlankInput(final String message) {
        if (message.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        }

        return message;
    }


}
