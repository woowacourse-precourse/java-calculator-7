package calculator.testdouble;

import calculator.numberExtractor.NumberExtractor;

import java.util.List;

public class NumberExtractorStub implements NumberExtractor {
	
	@Override
	public List<Integer> extract(String str, List<Character> separators) {
		return List.of(1, 2, 3);
	}
}
