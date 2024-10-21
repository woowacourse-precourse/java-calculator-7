package calculator.parser;

import calculator.model.CalculatorModel;
import calculator.model.LongCalculatorModel;

public interface LongMathematicalExpressionParser {

	public void parse(LongCalculatorModel model);

	public String getVALID_MATHEMATICAL_EXPRESSION_PATTERN();
}
