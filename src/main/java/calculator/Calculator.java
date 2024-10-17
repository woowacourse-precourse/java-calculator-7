package calculator;

import java.util.List;

public class Calculator {

	public int add(List<Integer> numberList) {
		int result = 0;
		for (int number : numberList) {
			result += number;
		}
		return result;
	}
}
