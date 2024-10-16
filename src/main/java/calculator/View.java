package calculator;

import camp.nextstep.edu.missionutils.Console;

public class View {
    public String input() {
        return Console.readLine();
    }
    public void printMessage() {
        System.out.println(CalculatorConstraint.INPUT_MESSAGE);
    }
}