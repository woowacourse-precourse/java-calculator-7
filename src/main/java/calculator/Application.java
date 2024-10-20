package calculator;

import calculator.splitter.DefaultStringSplitter;
import calculator.validator.DefaultValidator;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            String customDelimiter = extractCustomDelimiter(input);

            StringCalculator calculator = StringCalculator.create(
                    DefaultStringSplitter.create(),
                    DefaultValidator.create(customDelimiter)
            );

            String result = calculator.add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private static String extractCustomDelimiter(String input) {
        if (input.startsWith("//") && input.contains("\\n")) {
            int start = input.indexOf("//") + 2;
            int end = input.indexOf("\\n");
            return input.substring(start, end);
        }
        return "";
    }
}
