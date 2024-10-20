package calculator;

import calculator.Calculator.CalculatorService;
import calculator.IO.InputService;
import calculator.IO.OutputService;

public class FrontController {
    public void run() {
        AppConfig appConfig = AppConfig.getInstance();

        InputService inputService = appConfig.getInputService();
        OutputService outputService = appConfig.getOutputService();
        CalculatorService calculatorService = appConfig.getCalculatorService();

        // Input 작업 수행하기
        inputService.getInput();

        // 문자열 덧셈 연산하기
        calculatorService.calculateSum(inputService.getFormula(), inputService.getCustomSeparator());

        // 덧셈 연산 결과 출력하기
        outputService.printSum(calculatorService.getSum());
    }
}