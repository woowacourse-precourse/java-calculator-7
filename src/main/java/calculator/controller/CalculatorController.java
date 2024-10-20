package calculator.controller;

import calculator.service.SumService;
import calculator.validator.InputValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputValidator inputValidator;
    private final SumService sumService;
    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController() {
        this.inputValidator = new InputValidator();
        this.sumService = new SumService();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    // 사용자 입력을 받아 합계 계산
    public void run() {
        String input = inputView.getInput();

        // 입력값 검증
        if (inputValidator.isValidInput(input)) {
            // 유효한 입력인 경우 합계 계산
            int sum = sumService.calculateSum(input);
            outputView.printOutput(sum); // 출력 메시지 수정
        } else {
            throw new IllegalArgumentException(); // 예외 던지기
        }
    }
}