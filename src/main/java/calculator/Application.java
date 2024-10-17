package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println(OutputMessage.INPUT_ENCOURAGE.getMessage());
        String userInput = Console.readLine();
        InputValidator.validate(userInput);
        System.out.println(String.format("%s : %s", OutputMessage.RESULT.getMessage(), PlusCalculator.calculate(userInput)));
    }
}
