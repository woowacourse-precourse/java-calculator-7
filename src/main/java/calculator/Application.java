package calculator;

import camp.nextstep.edu.missionutils.Console;
import static calculator.constants.*;

public class Application {

    public static void main(String[] args) {
        System.out.println(InputMessage);
        String input = Console.readLine();

        StringCalculator calculator = new StringCalculator();

        try {
            int result = calculator.add(input);
            System.out.println(OutputMessage + result);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage);
        }
    }
}