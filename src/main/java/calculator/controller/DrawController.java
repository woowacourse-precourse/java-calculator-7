package calculator.controller;

import java.util.List;

import calculator.dto.request.FormulaReq;
import calculator.dto.response.DelimitersRes;
import calculator.service.DrawService;
import calculator.view.InputView;

public class DrawController {
	private final DrawService drawService;

	public DrawController() {
		this.drawService = new DrawService();
	}

	public List<Long> requestNumberDraw() {
		String formula = InputView.readLine();

		FormulaReq formulaReq = new FormulaReq(formula);

		DelimitersRes delimiters = drawService.generateDelimiters(formulaReq);

		return drawService.drawNumbers(delimiters.delimiters(), formulaReq);
	}
}
