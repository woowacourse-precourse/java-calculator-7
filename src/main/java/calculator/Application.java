package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        while(true) {
            System.out.println(OutputMessage.INPUT_ENCOURAGE.getMessage());
            System.out.println(String.format("%s : %s", OutputMessage.RESULT.getMessage(), PlusCalculator.calculate(Console.readLine())));
        }
    }
}
