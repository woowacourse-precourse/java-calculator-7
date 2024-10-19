package calculator.controller;

import calculator.domain.Delimiter;
import calculator.domain.Number;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    public void calculateString() {
        Delimiter delimiter = new Delimiter();
        String input = InputView.inputString();
        // 입력된 값이 없을 경우 결과로 0을 출력
        if (input.isEmpty()) {
            OutputView.printResult(0);
            return;
        }

        String[] numberArray = delimiter.changeInputLine(input);
        Number number = new Number(numberArray);
        OutputView.printResult(number.getSum());
    }
}
