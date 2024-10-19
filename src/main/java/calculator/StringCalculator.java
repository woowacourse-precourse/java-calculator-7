package calculator;

import camp.nextstep.edu.missionutils.Console;

public class StringCalculator {
    private static final String USER_INPUT_PROMPT = "덧셈할 문자열을 입력해 주세요.";

    private final Delimiter delimiter;
    private final Parser parser;

    public StringCalculator(Delimiter delimiter, Parser parser) {
        this.delimiter = delimiter;
        this.parser = parser;
    }

    public void run() {
        System.out.println(USER_INPUT_PROMPT);
        String input = Console.readLine();
        String[] stringNumbers;
        try {
            stringNumbers = delimiter.split(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        try {
            int[] numbers = parser.parseToNumber(stringNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }


    }
}
