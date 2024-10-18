package calculator;

import calculator.operations.SumCalculator;
import calculator.parser.InputParser;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.\n");

        String input = Console.readLine();
        InputParser inputParser = new InputParser(",:", "//", "\\n");
        ArrayList<Integer> numbers = inputParser.parse(input);
        int sum = SumCalculator.sum(numbers);
        System.out.println("결과 : " + sum);

        Console.close();
    }
}
