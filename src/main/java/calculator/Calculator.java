package calculator;

import java.util.List;

public class Calculator {
	private long totalSum;

	/**
	 * 숫자 하나 더하기
	 *
	 * @param num
	 */
	public void addNum(Integer num) {
		totalSum += num;
	}

	/**
	 * list의 모든 숫자들 더하기
	 *
	 * @param inputNums
	 */
	public void addNums(List<Integer> inputNums) {
		for (Integer n : inputNums) {
			addNum(n);
		}
	}

	public long getTotalSum() {
		return totalSum;
	}
}
