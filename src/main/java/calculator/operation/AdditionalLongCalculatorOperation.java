package calculator.operation;

import java.util.Arrays;

import calculator.model.LongCalculatorModel;

public class AdditionalLongCalculatorOperation implements LongCalculatorOperation {


	@Override
	public void operate(LongCalculatorModel model) {
		long result = Arrays.stream(model.getNumbers()).sum();
		model.setResultNumber(result);
	}
}
