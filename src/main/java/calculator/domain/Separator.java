package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Separator {
	private static final Separator INSTANCE = new Separator();
	private final List<Character> separators;

	private Separator() {
		this.separators = new ArrayList<>();
		separators.add(',');
		separators.add(':');
	}

	public void addSeparator(Character customSeparator) {
		this.separators.add(customSeparator);
	}

	public Character getSeparators(int index) {
		return separators.get(index);
	}

	public static Separator getInstance() {
		return INSTANCE;
	}
}
