package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();
        InputParser inputParser = new InputParser();
        int[] numbers = inputParser.parse(input);
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate(numbers);
        System.out.println("결과 : " + result);
    }
}
