package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String userInput = getUserInput();
        calculator.enter(userInput);
        Long sum = calculator.addAll();
        System.out.printf("결과 : %d", sum);
    }

    private static String getUserInput() {
        String input = Console.readLine().trim();
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 존재하지 않습니다.");
        }
        return input;
    }
}
