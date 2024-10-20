package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Calculator {
    public void calculate() {
        String input = readLine();
        String[] parsedInput = InputHandler.parse(input);
        for (String result : parsedInput) {
            System.out.println("결과 : " + result);
        }
    }
}
