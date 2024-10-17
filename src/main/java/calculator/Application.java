package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String userInput = getUserInput();
        calculator.enter(userInput);
    }

    private static String getUserInput() {
        String input = Console.readLine().trim();
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 존재하지 않습니다.");
        }
        return input;
    }
}
