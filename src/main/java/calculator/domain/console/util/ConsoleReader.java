package calculator.domain.console.util;

import camp.nextstep.edu.missionutils.Console;

public final class ConsoleReader {

    public static String read() {
        return validateBlankInput(Console.readLine());
    }

    private static String validateBlankInput(final String message) {
        if (message.isBlank()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }

        return message;
    }


}
