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
            throw new IllegalArgumentException("시스템 오류로 프로그램을 종료합니다. 다시 실행해 주세요");
        }
    }

    private void validateWhiteSpaces(final String input) {
        if (isWhitespaces(input)) {
            throw new IllegalArgumentException("공백만 입력할 수 없습니다. 빈 문자열은 0입니다.");
        }
    }

    private boolean isWhitespaces(final String input) {
        return !input.isEmpty() && input.isBlank();
    }

}
