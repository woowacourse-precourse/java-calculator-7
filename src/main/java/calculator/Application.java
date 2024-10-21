package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = Console.readLine();

        InputProcessor inputProcessor = new InputProcessor(userInput);
        String[] numbers = inputProcessor.processInput();

        Calculator calculator = new Calculator();
        int sumResult = calculator.sum(numbers);

        System.out.println("결과 : " + sumResult);
    }
}
