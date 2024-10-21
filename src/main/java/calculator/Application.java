package calculator;

import calculator.io.InputHandler;
import calculator.service.Calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        Calculator calculator = new Calculator();

        System.out.println("덧셈할 문자열을 입력해주세요.");
        String inputStr = inputHandler.getInput();

        calculator.parseAndAddNumbers(inputStr);
        int result = calculator.sum();

        System.out.println("결과 : " + result);
        Console.close();
    }
}