package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class StringCalculatorController {

    private final InputView inputView;
    private final OutputView outputView;
    private final CalculatorService calculatorService;

    public StringCalculatorController(InputView inputView, OutputView outputView, CalculatorService calculatorService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculatorService = calculatorService;
    }

    public void run() {
        try {
            // 1. 사용자 입력 받기
            String input = inputView.input();

            // 2. 입력이 빈 문자열이거나 공백일 경우 0 반환
            if (isBlank(input)) {
                outputView.printResult(0);
                return;
            }

            // 3. 서비스에서 계산 처리
            int result = calculatorService.calculate(input);

            // 4. 결과 출력
            outputView.printResult(result);
        } catch (IllegalArgumentException e) {
            // 예외 발생 시 애플리케이션 종료
            throw e;  // 예외를 던져서 프로그램 종료를 유도
        }
    }

    private boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }
}