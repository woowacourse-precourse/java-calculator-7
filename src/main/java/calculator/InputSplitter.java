package calculator;

import static calculator.Application.*;

import java.util.HashSet;
import java.util.Set;

public class InputSplitter {
	private final Set<String> inputSplitters = new HashSet<>();

	public InputSplitter(String input) {
		for (String originalSplitter : originalSplitters) {
			if(input.contains(originalSplitter)){
				inputSplitters.add(originalSplitter);
			}
		}
	}
}
