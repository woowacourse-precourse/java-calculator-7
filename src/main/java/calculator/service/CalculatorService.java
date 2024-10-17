package calculator.service;

import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorService {

    static final String INPUT_DESCRIPTION = "덧셈할 문자 열을 입력해 주세요.";
    static final String OUTPUT_DESCRIPTION = "결과 : ";

    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorService(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        /**
         * InputView
         * 1. 사용자에게 입력 받음
         * 2. 입력 받은 문자열 검증
         * 3. 검증 과정이 끝난 문자열을 정수 배열로 변환
         */
        inputView.printMessage(INPUT_DESCRIPTION);
        int[] validateIntArray = inputView.getUserInput();
        /**
         * OutputView
         * 1. InputView에서 검증을 마친 정수 배열을 합산
         * 2. 합산한 결과 출력
         */
        int sum = outputView.sumElements(validateIntArray);
        outputView.printResult(OUTPUT_DESCRIPTION, sum);
    }
}
