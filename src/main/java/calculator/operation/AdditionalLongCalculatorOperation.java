package calculator.operation;

import java.util.Arrays;

public class AdditionalLongCalculatorOperation implements LongCalculatorOperation{

	@Override
	public long operate(long[] numbers) {
		return Arrays.stream(numbers).sum();
	}
}
