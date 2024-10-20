package custom.controller;

import camp.nextstep.edu.missionutils.Console;
import custom.service.CalculatorService;
import custom.view.CalculatorView;

public class CalculatorController {
    private final CalculatorService calculatorService;
    private final CalculatorView calculatorView;

    public CalculatorController() {
        this.calculatorService = new CalculatorService();
        this.calculatorView = new CalculatorView();
    }

    public void run() {
        calculatorView.displayInputPrompt();
        String input = Console.readLine();

        try {
            int result = calculatorService.calculate(input);
            calculatorView.displayResult(result);
        } catch (IllegalArgumentException e) {
            calculatorView.displayError("잘못된 입력입니다.");
            throw e; // 프로그램 종료
        }
    }
}
