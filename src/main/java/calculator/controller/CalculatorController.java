package calculator.controller;

import calculator.model.Calculator;
import calculator.model.InputValidator;
import calculator.view.ConsoleView;


public class CalculatorController {
    private final Calculator calculator;
    private final InputValidator validator;
    private final ConsoleView view;

    public CalculatorController(Calculator calculator, InputValidator validator, ConsoleView view) {
        this.calculator = calculator;
        this.validator = validator;
        this.view = view;
    }

    // 사용자 입력을 받아 계산 결과를 출력하는 메서드
    public void run() {
        String input = view.getInput(); // 사용자의 입력을 받음
        String[] validatedNumbers = validator.validate(input); // 입력값 검증 수행
        int result = calculator.add(validatedNumbers); // 검증된 숫자 배열 계산 수행
        view.printResult(result); // 결과 출력
    }

}

