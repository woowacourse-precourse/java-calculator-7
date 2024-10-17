package calculator.numberExtractor;

import java.util.ArrayList;
import java.util.List;

public class NumberExtractorImpl implements NumberExtractor {
	
	@Override
	public List<Integer> extract(String str, List<Character> separators) {
		int currentNumber = 0;
		List<Integer> numberList = new ArrayList<>();
		
		for (int i = 0; i < str.length(); i++) {
			char currentChar = str.charAt(i);
			
			if (separators.contains(currentChar)) {
				numberList.add(currentNumber);
				currentNumber = 0;
			} else {
				if (!Character.isDigit(currentChar)) {
					throw new IllegalArgumentException("입력된 문자열에 구분자와 숫자가 아닌 문자가 포함되어 있습니다.");
				}
				currentNumber *= 10;
				currentNumber += Character.getNumericValue(currentChar);
			}
		}
		
		numberList.add(currentNumber);
		
		return numberList;
	}
}
