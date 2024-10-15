package calculator.controller;

import calculator.service.CalculateService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputView inputView;
    private final CalculateService calculateService;
    private final OutputView outputView;

    public CalculatorController(InputView inputView, CalculateService calculateService, OutputView outputView) {
        this.inputView = inputView;
        this.calculateService = calculateService;
        this.outputView = outputView;
    }

    /***
     * 계산기 프로그램의 작동을 위해 제일 먼저 실행되는 메서드입니다.
     */
    public void run() {
        String inputString = readInputStringFromInputView();
        int sum = calculateService.calculate(inputString);
        outputView.printResult(sum);
    }

    /***
     * InputView 로 부터 사용자의 입력을 받아옵니다.
     * @return : InputView 에서 읽어온 inputString 을 반환합니다.
     */
    private String readInputStringFromInputView() {
        return inputView.readInputString();
    }
}
