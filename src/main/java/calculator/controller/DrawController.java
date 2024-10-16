package calculator.controller;

import java.util.List;

import calculator.service.DrawService;
import calculator.view.InputView;

public class DrawController {
	private final DrawService drawService;

	public DrawController() {
		this.drawService = new DrawService();
	}

	public List<Long> requestNumberDraw() {
		String formula = InputView.readLine();
		return drawService.drawNumbers();
	}
}
