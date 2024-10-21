package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

// Controller를 담당하는 부분
// 문자열 계산기의 전반적인 서비스 흐름을 담당합니다.
public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;

    // 생성자를 통한 의존성 주입을 실시합니다.
    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    // 계산기의 실행을 담당합니다.
    // input받기 -> 계산 -> 결과 출력
    // 계산된 결과를 outputview로 전달하여 출력
    public void run() {

        String input = inputView.numbersInputView();

        // 해당 부분의 Calculator를 CalculatorService로 변경해도 좋을 것 같음
        Calculator calculator = new Calculator();
        int result = calculator.calculate(input);

        outputView.printResult(result);
    }


}
