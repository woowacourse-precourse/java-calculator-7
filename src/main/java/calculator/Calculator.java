package calculator;

public class Calculator {
	private String str;
	private long totalSum;
	private char[] separator = new char[3];

	public Calculator() {
		str = "";
		totalSum = 0;
		separator[0] = ',';
		separator[1] = ':';
	}

}
