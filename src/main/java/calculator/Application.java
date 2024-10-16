package calculator;

import calculator.controller.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {

        // 1. 사용자로부터 입력받은 값을 저장
        String input = InputView.getInput();

        // 2. 입력값에 대한 계산 실행
        Calculator calculator = new Calculator();
        int result = Calculator.calculate(input);

        // 3. 계산 결과 출력
        OutputView.printResult(result);
    }
}
