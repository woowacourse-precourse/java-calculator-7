package calculator;

import calculator.input.InputHandler;
import calculator.input.InputRulePrinter;
import calculator.service.ResultPrinter;
import calculator.service.StringAddCalculator;

public class Application {
    public static void main(String[] args) {
        // 입력 규칙 안내
        InputRulePrinter rulePrinter = new InputRulePrinter();
        rulePrinter.printInputRules();

        // 입력 문자열 받기
        InputHandler inputHandler = new InputHandler();
        String userInput = inputHandler.getUserInput();

        // 문자열 처리 및 계산
        int result = StringAddCalculator.add(userInput);

        // 결과 출력
        ResultPrinter.printResult(result);
    }
}
