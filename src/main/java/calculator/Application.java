package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            String input = Input.readString();
            StringCalculator calculator = new StringCalculator();
            int sum = calculator.calculateSum(input);
            Output.printResult(sum);
        } finally {
            Console.close();
        }
    }
}
