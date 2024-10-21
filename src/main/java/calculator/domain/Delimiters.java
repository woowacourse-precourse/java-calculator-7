package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Delimiters {
	private List<String> delimiters = new ArrayList<>();

	public Delimiters() {
		delimiters.add(",");
		delimiters.add(":");
	}

	public List<String> getDelimiters() {
		return new ArrayList<>(delimiters);
	}

	public void addDelimiter(String newDelimiter) {
		delimiters.add(newDelimiter);
	}


}


