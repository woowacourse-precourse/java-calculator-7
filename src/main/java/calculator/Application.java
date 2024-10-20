package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String inputText = Console.readLine();
        InputParser inputParser = new InputParser(inputText);
        Calculator calculator = new Calculator(inputParser);
        int totalSum = calculator.calculateTotalSum();
        System.out.printf("결과 : %d\n", totalSum);
        }
}
