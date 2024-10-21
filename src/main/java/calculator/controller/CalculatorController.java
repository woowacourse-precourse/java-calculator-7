package calculator.controller;

import calculator.domain.Delimiter;
import calculator.domain.Number;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    public void calculateString() {
        Delimiter delimiter = new Delimiter();
        // 문자열 입력
        String input = InputView.inputString();

        // 입력받을 값을 문자열 배열로 반환
        String[] numberArray = delimiter.changeInputLine(input);

        // 배열에 저장된 값을 검사하고 숫자를 저장하는 List에 저장
        Number number = new Number(numberArray);

        // 결과 출격
        OutputView.printResult(number.getSum());
    }
}
