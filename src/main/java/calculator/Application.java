package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String inputString = Console.readLine();
        StringAddCalculator stringAddCalculator = new StringAddCalculator();

        System.out.println(stringAddCalculator.calculate(inputString));
    }
}
