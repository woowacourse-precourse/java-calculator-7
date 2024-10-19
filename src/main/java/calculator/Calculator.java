package calculator;

import java.util.List;

public class Calculator {
	private long totalSum;

	public void addNums(List<Integer> inputNums) {
		for (Integer n : inputNums) {
			totalSum += n;
		}
	}

	public long getTotalSum() {
		return totalSum;
	}
}
