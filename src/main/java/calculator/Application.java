package calculator;

import calculator.exception.InvalidInputException;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("문자열을 입력하세요.");

        String input = Console.readLine();
        try {
            String result = StringCalculator.calculate(input);
            System.out.println(result);
        } catch (InvalidInputException e) {
            System.err.println(e.getMessage());
        }
    }
}
