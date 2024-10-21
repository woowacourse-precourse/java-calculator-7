package calculator.controller;

import calculator.model.Delimiter;
import calculator.model.Number;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private Delimiter delimiter;
    private Number number;
    private InputView inputView;
    private OutputView outputView;

    public CalculatorController(Delimiter delimiter, Number number, InputView inputView, OutputView outputView) {
        this.delimiter = delimiter;
        this.number = number;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    // 계산 실행
    public void run() {
        try {
            // 사용자 입력 받기
            String input = inputView.getUserInput();

            // 커스텀 구분자 처리
            // input = delimiter.processCustomDelimiter(input);

            // 구분자로 문자열을 분리
            String[] tokens = delimiter.split(input);

            // 숫자로 변환하고 합 계산
            int result = number.calculateSum(tokens);

            // 결과 출력
            outputView.printResult(result);

        } catch (IllegalArgumentException e) {
            // 예외 발생 시 프로그램을 종료 (에러 메시지 출력하지 않음)
            System.exit(1);
        }
    }
}
