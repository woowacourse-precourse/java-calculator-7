package calculator.testdouble;

import calculator.customSeparatorExtractor.CustomSeparatorExtractor;

import java.util.List;

public class CustomSeparatorExtractorStub implements CustomSeparatorExtractor {
	
	
	@Override
	public List<Character> extract(String str) {
		return List.of('(', ')');
	}
}
