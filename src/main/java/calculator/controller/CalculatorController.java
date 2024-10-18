package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final CalculatorService calculatorService = new CalculatorService();

    public void run() {
        String inputString = inputView.inputMessage(); // 입력 값 받아오기
        int result = calculatorService.calculate(inputString); // 계산 결과
        outputView.outputMessage(result); // 결과 출력
    }
}
