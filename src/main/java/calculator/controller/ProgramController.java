package calculator.controller;

import java.util.List;

import calculator.domain.Calculator;

public class ProgramController {
	private final DrawController drawController;

	public ProgramController() {
		this.drawController = new DrawController();
	}

	public void run() {
		Calculator calculator = new Calculator(drawNumber());
		calculator.calculateSum();
		System.out.print("결과 : ");
		System.out.println(calculator.getSum());

	}

	private List<Long> drawNumber() {
		return drawController.requestNumberDraw();
	}

}
