package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        String input = readLine();
        Calculator calculator = new Calculator(input);
        calculator.run();
    }
}
