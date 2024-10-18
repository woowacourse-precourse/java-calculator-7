package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Calculator {

    private static final String INPUT = "덧셈할 문자열을 입력해주세요.";

    public static void Run() {
        System.out.println(INPUT);
        String input = Console.readLine();
        int sum = Sum(input);
        System.out.println("sum = " + sum);
    }

    private static int Sum(String input) {
        String contents = Parser.getNumberString(input);
        System.out.println("contents = " + contents);
        List<String> separators = Parser.parse(input);
        int[] numbers = Parser.getNumbers(contents, separators);
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static void End() {
    }
}
