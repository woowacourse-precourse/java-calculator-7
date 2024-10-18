package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Separator {
	private static final Separator INSTANCE = new Separator();
	private final List<Character> separators;
	private int size;

	private Separator() {
		this.separators = new ArrayList<>();
		separators.add(',');
		separators.add(':');
		size = 2;
	}

	public void addSeparator(Character customSeparator) {
		separators.add(customSeparator);
		size++;
	}

	public Character getSeparators(int index) {
		return separators.get(index);
	}

	public int getSize() {
		return this.size;
	}

	public static Separator getInstance() {
		return INSTANCE;
	}
}
