package calculator.factory;

import java.util.HashSet;
import java.util.Set;

import calculator.constant.DelimiterConstant;

public class DelimitersFactory {
	public static Set<String> getDelimiters() {
		Set<String> delimiters = new HashSet<>();
		delimiters.add(DelimiterConstant.COMMA);
		delimiters.add(DelimiterConstant.COLON);
		return delimiters;
	}
}
