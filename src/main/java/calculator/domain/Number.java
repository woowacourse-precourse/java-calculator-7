package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Number {
	private List<Integer> numbers;

	private Number() {
		this.numbers = new ArrayList<>();
	}

	public int getNumbers(int index) {
		return numbers.get(index);
	}

	public void addNumber(int number) {
		this.numbers.add(number);
	}

	public static Number getInstance() {
		return new Number();
	}
}
