package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();

        StringCalculator stringCalculator = new StringCalculator();
        stringCalculator.calculate(input);
    }
}
