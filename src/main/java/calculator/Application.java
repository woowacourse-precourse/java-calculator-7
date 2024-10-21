package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해주세요.\n";
    private static final String OUTPUT_MESSAGE = "결과 : ";

    public static void main(String[] args) {
        System.out.print(INPUT_MESSAGE);
        String input = Console.readLine();
        Calculator calculator = new Calculator();
        double result = calculator.calculate(input);
        System.out.println(OUTPUT_MESSAGE + result);
    }
}
