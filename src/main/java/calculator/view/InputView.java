package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String read() {
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();
            validate(input);
            return input;
        } finally {
            Console.close();
        }
    }

    private void validate(final String input) {
        validateNull(input);
        validateWhiteSpaces(input);
    }

    private void validateNull(final String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
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
