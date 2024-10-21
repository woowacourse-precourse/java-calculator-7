package calculator.parser;

import java.util.Set;

import calculator.model.CalculatorModel;

public interface SeparatorParser {

	public void parse(CalculatorModel model);

	public String getVALID_CUSTOM_SEPARATOR_PATTERN();

	public Set getSeparators();
}
