package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Console.*;


public class Application {

    public static void main(String[] args) {
        String input = readLine();
        int result = StringCalculator.add(input);
        System.out.println("결과 : " + result);
    }
}
