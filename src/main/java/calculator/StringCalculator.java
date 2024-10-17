package calculator;

import camp.nextstep.edu.missionutils.Console;

public class StringCalculator {
    private static final String USER_INPUT_PROMPT = "덧셈할 문자열을 입력해 주세요.";

    private final Delimiter delimiter;

    public StringCalculator(Delimiter delimiter) {
        this.delimiter = delimiter;
    }

    public void run() {
        System.out.println(USER_INPUT_PROMPT);
        String input = Console.readLine();

        try {
            String[] numbers = delimiter.split(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
