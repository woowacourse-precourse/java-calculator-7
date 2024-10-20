package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Calculator {
    public void calculate() {
        String input = readLine();
        String delimiter = InputHandler.parse(input);
        System.out.println("구분자 : " + delimiter);
    }
}
