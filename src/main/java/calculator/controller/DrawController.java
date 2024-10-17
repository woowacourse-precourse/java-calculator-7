package calculator.controller;

import java.util.List;

import calculator.dto.request.FormulaReq;
import calculator.dto.response.DelimitersDto;
import calculator.service.DrawService;
import calculator.view.InputView;

public class DrawController {
	private final DrawService drawService;

	public DrawController() {
		this.drawService = new DrawService();
	}

	public List<Long> requestNumberDraw() {
		while(true) {
			try {
				System.out.print("입력하세요: ");
				String formula = InputView.readLine();

				FormulaReq formulaReq = new FormulaReq(formula);

				DelimitersDto delimiters = drawService.generateDelimiters(formulaReq);

				System.out.println(delimiters.delimiters());
				return drawService.drawNumbers(delimiters.delimiters(), formulaReq);
			} catch (IllegalArgumentException exception) {
				System.out.println(exception.getMessage());
			}
		}
	}
}
