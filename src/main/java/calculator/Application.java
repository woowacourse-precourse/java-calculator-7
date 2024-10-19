package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String PROMPT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_FORMAT = "결과 : %d";

    public static void main(String[] args) {
        try {
            System.out.println(PROMPT_MESSAGE);
            String input = Console.readLine();
            StringCalculator calculator = new StringCalculator();
            int result = calculator.calculate(input);
            System.out.printf(RESULT_FORMAT, result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}