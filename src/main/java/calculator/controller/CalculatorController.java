package calculator.controller;

import calculator.model.Calculator;
import calculator.model.SumCalculator;
import calculator.model.DelimiterParser;
import calculator.view.InputView;
import calculator.view.ResultView;

import static calculator.model.Validator.inputValidator;

public class CalculatorController {
    private final Calculator calculator;

    public CalculatorController(Calculator calculator) {
        this.calculator = calculator;
    }

    // 사용자의 입력을 처리하고 결과를 반환
    public void run() {
        String input = InputView.getInput();

        // 입력값 유효성 검사
        boolean isValidInput = inputValidator(input);
        if (!isValidInput) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다.");
        }

        // 공백 입력일 경우 0 출력 후 종료
        if (input.equals("\"\"")) {
            ResultView.showResult(0);
            return;
        }

        DelimiterParser parser = new DelimiterParser();
        String[] num = parser.inputParser(input);

        // 계산을 위한 Calculator 인스턴스 생성
        int result = calculator.add(num);

        // 결과 출력
        ResultView.showResult(result);
    }
}
