package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String BLANK = " ";

    public String inputStrings() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        validateBlank(input);

        return input;
    }

    private void validateBlank(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
        }
    }

    private boolean isBlank(String input) {
        return input.contains(BLANK);
    }
}



