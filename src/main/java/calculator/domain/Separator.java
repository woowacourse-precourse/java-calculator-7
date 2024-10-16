package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Separator {

	private List<Character> separators;

	private Separator() {
		this.separators = new ArrayList<>();
		separators.add(',');
		separators.add(':');
	}

	public void addSeparator(Character customSeparator) {
		this.separators.add(customSeparator);
	}

	public List<Character> getSeparators() {
		return separators;
	}

	public static Separator getInstance() {
		return new Separator();
	}
}
