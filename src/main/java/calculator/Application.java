package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();
            long sum;

            ArrayList<Integer> parsedInput = InputParser.parseInput(input);
            sum = Calculator.sum(parsedInput);

            System.out.println("결과 : "+sum);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
