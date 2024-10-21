package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        ArrayList<Integer> parsedInput = InputParser.parseInput(input);
        long sum = Calculator.sum(parsedInput);
        System.out.println("결과 : "+sum);
    }
}
