package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try{
            String input = Console.readLine();
            StringCalculator calculator = new StringCalculator();
            int result = calculator.calculate(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
