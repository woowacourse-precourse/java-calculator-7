package calculator.controller;

import calculator.model.StringCalculator;
import calculator.view.InputValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class MainController {
    public void run() {
		String input = InputView.readInput("덧셈할 문자열을 입력해 주세요.");
		String delimiter = InputValidator.extractDelimiter(input);
        int result = StringCalculator.sumNumbers(input, delimiter); // 합 계산
	}
}
