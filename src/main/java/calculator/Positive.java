package calculator;

public class Positive {
	private final int num;

	private static void validateSplitNumber(final int splitNum){
		if (splitNum <= 0) {
			throw new IllegalArgumentException();
		}
	}

	public Positive(int num) {
		this.num = num;
	}

	public static Positive inputPositive(String inputString) {
		int inputNum = Integer.parseInt(inputString);
		validateSplitNumber(inputNum);
		return new Positive(inputNum);
	}

	public static Positive zero(){
		return new Positive(0);
	}

	public int getNum() {
		return num;
	}

	public Positive add(Positive other) {
		return new Positive(other.getNum() + this.num);
	}

	public void printResult() {
		System.out.println("결과 = " + num);
	}
}
