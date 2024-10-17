package calculator;

import camp.nextstep.edu.missionutils.Console;

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

	public void run() {
		enter();
	}

	private void enter() {
		str = Console.readLine();
	}
}
