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
            handleUserInput();
        } catch (IllegalArgumentException e) {
            // 예외 발생 시 프로그램 종료
            throw e; // 예외를 던져서 프로그램 종료 유도
        }
    }

    private void handleUserInput() {
        String input = inputView.input();

        if (isBlank(input)) {
            handleBlankInput();
            return;
        }

        processValidInput(input);
    }

    private void handleBlankInput() {
        outputView.printResult(0);
    }

    private void processValidInput(String input) {
        int result = calculateResult(input);
        outputView.printResult(result);
    }

    private int calculateResult(String input) {
        return calculatorService.calculate(input);
    }

    // 공백인지 빈 문자열인지 확인
    private boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }

}