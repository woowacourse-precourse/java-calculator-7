package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Console.*;


public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = readLine();
        try {
            int result = StringCalculator.add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
