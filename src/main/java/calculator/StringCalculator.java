package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class StringCalculator {
    private static final String USER_INPUT_PROMPT = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_PREFIX = "결과 : ";

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
        stringNumbers = delimiter.split(input);

        int[] numbers;
        numbers = parser.parseToNumber(stringNumbers);

        int summary = Arrays.stream(numbers).sum();
        System.out.println(RESULT_PREFIX + summary);
    }
}
