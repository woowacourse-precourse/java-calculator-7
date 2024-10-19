package calculator;

public class Positive {
	private final int num;

	private static void validateSplitNumber(final int splitNum){
		if (splitNum <= 0) {
			throw new IllegalArgumentException();
		}
	}

	public Positive(int num) {
		validateSplitNumber(num);
		this.num = num;
	}

	public Positive add(int other) {
		return new Positive(other + this.num);
	}
}
