package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String USER_INPUT_PROMPT = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_PREFIX = "결과 : ";

    private final Calculator calculator;
    private final Delimiter delimiter;
    private final NumberParser numberParser;

    public Application(Calculator calculator, Delimiter delimiter, NumberParser numberParser) {
        this.calculator = calculator;
        this.delimiter = delimiter;
        this.numberParser = numberParser;
    }

    public static void main(String[] args) {
        Delimiter delimiter = new Delimiter();
        NumberParser numberParser = new NumberParser();
        Calculator calculator = new Calculator();
        Application app = new Application(calculator, delimiter, numberParser);

        app.run(delimiter, numberParser, calculator);
    }

    private void run(Delimiter delimiter, NumberParser numberParser, Calculator calculator) {
        System.out.println(USER_INPUT_PROMPT);
        String input = Console.readLine();

        String[] stringNumbers = delimiter.split(input);
        int[] numbers = numberParser.parse(stringNumbers);
        int summary = calculator.getSummary(numbers);

        System.out.println(RESULT_PREFIX + summary);
    }
}
