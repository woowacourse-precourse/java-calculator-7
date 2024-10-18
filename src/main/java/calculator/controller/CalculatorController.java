package calculator.controller;

import calculator.model.Delimiter;
import calculator.model.Number;
import calculator.view.InputView;

public class CalculatorController {
    private InputView inputView;

    public CalculatorController(InputView inputView) {
        this.inputView = inputView;
    }

    public int processInput() {
        try {
            String input = inputView.getInputString();

            Delimiter delimiter = new Delimiter(input);
            delimiter.checkCustomDelimiter();
            String[] splitNumbers = delimiter.splitString();

            Number number = new Number(splitNumbers);
            return number.addCalculator();

        } catch (IllegalArgumentException e) {
            // 예외 발생 시 메시지 출력 및 애플리케이션 종료
            System.out.println(e.getMessage());
            throw e;
        }
    }
}


