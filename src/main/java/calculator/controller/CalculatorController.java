package calculator.controller;

import calculator.controller.io.InputHandler;
import calculator.controller.io.OutputHandler;
import calculator.model.CalculatorModel;
import calculator.model.InputParser;

public class CalculatorController {
    private final InputHandler inputHandler; // 사용자 입력 처리 핸들러
    private final OutputHandler outputHandler; // 출력 처리 핸들러
    private final CalculatorModel calculatorModel; // 계산 로직을 처리 계산기 모델
    private final InputParser inputParser; // 입력 파싱 모델

    public CalculatorController(InputHandler inputHandler, OutputHandler outputHandler,
                                CalculatorModel calculatorModel, InputParser inputParser) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.calculatorModel = calculatorModel;
        this.inputParser = inputParser;
    }

    public void run() {
        // 사용자로부터 입력을 받음
        String userInput = inputHandler.getUserInput();

        // 입력된 문자열을 숫자로 변환
        int[] operands = inputParser.extractOperands(userInput);

        // 변환된 숫자들로 계산을 수행
        int result = calculatorModel.calculate(operands);

        // 계산 결과를 출력
        outputHandler.displayResult(result);
    }
}
