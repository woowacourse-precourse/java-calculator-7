package calculator.customSeparatorExtractor;

import java.util.ArrayList;
import java.util.List;

public class CustomSeparatorExtractorImpl implements CustomSeparatorExtractor {
	
	@Override
	public List<Character> extract(String str) {
		List<Character> extractedSeparators = new ArrayList<>();
		
		if (str != null && !str.isBlank()) {
			for (char ch : str.toCharArray()) {
				extractedSeparators.add(ch);
			}
		}
		
		return extractedSeparators;
	}
}
