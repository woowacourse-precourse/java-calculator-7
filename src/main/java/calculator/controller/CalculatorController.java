package calculator.controller;

import calculator.domain.Form;
import calculator.util.Calculator;
import calculator.util.FormParser;
import calculator.util.NumberParser;
import calculator.util.StringSplitter;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    public void run() {
        try {
            // 입력값 -> String -> Form
            String input = InputView.read();
            Form form = FormParser.makeForm(input);

            // Form -> String[] -> int[]
            String[] str = StringSplitter.stringToArray(form);
            int[] arr = NumberParser.stringToIntArray(str);

            // int[] 합 계산
            int sum = Calculator.calculate(arr);

            // 결과 출력
            OutputView.printResult(sum);

        } catch (Exception e) {
            // 에러 출력
            OutputView.printError("올바르지 않은 형식의 입력입니다.");

            throw new IllegalArgumentException();
        }
    }
}
