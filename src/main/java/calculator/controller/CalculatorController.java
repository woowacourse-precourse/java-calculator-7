package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
	private final InputView inputView;
	private final OutputView outputView;

	public CalculatorController() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
	}

	public void run() {
		outputView.printStartMessage();
		String input = inputView.getInput();

		// todo: 예시 데이터 서비스 로직으로 변경 필요
		int result = 6;
		outputView.printResult(result);

	}
}
