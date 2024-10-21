package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println(Message.getInputMessage());
        String inputString = Console.readLine();

        StringAddCalculator stringAddCalculator = new StringAddCalculator();

        System.out.println(Message.getOutputMessage() + stringAddCalculator.calculate(inputString));
    }
}
