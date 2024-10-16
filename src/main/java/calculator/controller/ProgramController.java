package calculator.controller;

import java.util.List;

import calculator.domain.Calculator;

public class ProgramController {
	private final DrawController drawController;

	public ProgramController() {
		this.drawController = new DrawController();
	}

	public void run() {
		while(true) {
			List<Long> numbers = drawNumber();
		}
	}

	private List<Long> drawNumber() {
		return drawController.requestNumberDraw();
	}

}
