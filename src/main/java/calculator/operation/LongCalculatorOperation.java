package calculator.operation;

@FunctionalInterface
public interface LongCalculatorOperation {
	public long operate(long[] numbers);
}
