package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Console.*;


public class Application {

    public static void main(String[] args) {
        String input = readLine();
        try {
            double result = StringCalculator.add(input);
            System.out.printf("결과 : %f%n", result);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
