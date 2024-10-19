package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String read() {
        String input;
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            input = Console.readLine();
            validateWhiteSpaces(input);
        } finally {
            Console.close();
        }
        return input;
    }

    private void validateWhiteSpaces(final String input) {
        if (isWhitespaces(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isWhitespaces(final String input) {
        return !input.isEmpty() && input.isBlank();
    }

}
