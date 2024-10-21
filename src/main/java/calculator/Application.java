package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {


    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        CalculationUtil calculationUtil = new CalculationUtil(input);
        calculationUtil.validInput();

        List<Integer> numbers = calculationUtil.getNumbers();

        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }

        System.out.println("결과: " + sum);
    }
}
