package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();
        InputHandler inputHandler = new InputHandler();

        int result = inputHandler.processInput(input);
        System.out.println("결과 : " + result);
    }
}