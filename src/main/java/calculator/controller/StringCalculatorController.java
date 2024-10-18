package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

// 사용자의 입력을 받고 처리한 후 결과를 출력
public class StringCalculatorController {

    private final InputView inputView;
    private final OutputView outputView;
    private final CalculatorService calculatorService;

    public StringCalculatorController(InputView inputView, OutputView outputView, CalculatorService calculatorService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculatorService = calculatorService;
    }

    // 프로그램 실행
    public void run() {
        try {
            handleUserInput();
        } catch (IllegalArgumentException e) {
            // 예외 발생 시 프로그램 종료
            throw e; // 예외를 던져서 프로그램 종료 유도
        }
    }

    // 사용자 입력 처리하는 메소드
    private void handleUserInput() {
        String input = inputView.input();

        // 입력이 공백이거나 빈 문자열인 경우 0 출력, 그렇지 않으면 계산 후 결과 출력
        int result = isBlank(input) ? 0 : calculatorService.calculate(input);
        outputView.printResult(result);
    }

    // 공백인지 빈 문자열인지 확인
    private boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }

}