package controller;

import model.StringCalculator;
import view.InputView;
import view.OutputView;

public class CalculatorController {
    public void run() {
        String input = InputView.getInput();
        try {
            int result = StringCalculator.add(input);
            OutputView.printResult(result);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage()); // 에러 메시지 출력
        }
    }
}
