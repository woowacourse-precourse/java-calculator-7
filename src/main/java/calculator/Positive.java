package calculator;

public class Positive {
	private int num;

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

	public void add(Positive other) {
		this.num = this.num + other.getNum();
	}

	public void printResult() {
		System.out.println("결과 : " + num);
	}
}
