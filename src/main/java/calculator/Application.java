package calculator;

import calculator.calculator.SumCalculator;
import calculator.parser.InputParser;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        InputParser inputParser = new InputParser();
        SumCalculator calculator = new SumCalculator();

        List<Integer> numbers = inputParser.parse(input);
        int sum = calculator.add(numbers);

        System.out.println("결과 : " + sum);
        Console.close();
    }
}