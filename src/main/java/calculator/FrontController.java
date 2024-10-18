package calculator;

import calculator.Calculator.CalculatorService;
import calculator.IO.InputService;

public class FrontController {
    public void run() {
        AppConfig appConfig = AppConfig.getInstance();

        InputService inputService = appConfig.getInputService();
        CalculatorService calculatorService = appConfig.getCalculatorService();

        // 덧셈할 문자열 입력 받기
        inputService.readFormula();

        // 문자열 검사하기
        inputService.checkValidFormula();

        // 문자열 덧셈 연산하기
        calculatorService.calculateSum(inputService.getFormula(), inputService.getCustomSeparator());
    }
}