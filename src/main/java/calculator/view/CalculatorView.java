package calculator.view;

import calculator.model.CalculatorModel;

public interface CalculatorView {
	public String input();

	public void output(CalculatorModel model);
}
