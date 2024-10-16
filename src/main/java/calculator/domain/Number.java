package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Number {

	private List<Integer> numbers;
	private int size;

	private Number() {
		this.numbers = new ArrayList<>();
		this.size = 0;
	}

	public int getNumber(int index) {
		return numbers.get(index);
	}

	public void addNumber(int number) {
		this.numbers.add(number);
		this.size += 1;
	}

	public int getSize() {
		return this.size;
	}

	public static Number getInstance() {
		return new Number();
	}
}
