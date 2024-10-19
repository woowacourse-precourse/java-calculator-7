package calculator.helper;

import java.util.Arrays;
import java.util.List;
import calculator.util.TypeConversion;

public class ParseHelper {
	public List<Long> extractNumbers(String formula, String regex) {
		return Arrays.stream(formula.split(regex))
			.map(TypeConversion::convertStringToLong)
			.toList();
	}
}
