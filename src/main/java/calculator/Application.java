package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        String input = Console.readLine();
        Calculator calculator = new Calculator(input);

        Integer result = calculator.caculate();

        System.out.printf("결과 : %d\n", result);
    }
}
