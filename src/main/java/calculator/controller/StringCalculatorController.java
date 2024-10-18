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

        if (isBlank(input)) {
            handleBlankInput();
            return;
        }

        processValidInput(input);
    }

    // 빈 입력일 경우 0을 출력하는 메소드
    private void handleBlankInput() {
        outputView.printResult(0);
    }

    // 유효한 입력일 경우 계산을 처리하는 메소드
    private void processValidInput(String input) {
        int result = calculateResult(input);
        outputView.printResult(result);
    }

    // 입력된 문자열을 계산하는 메소드
    private int calculateResult(String input) {
        return calculatorService.calculate(input);
    }

    // 공백인지 빈 문자열인지 확인
    private boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }

}