package calculator.util;

import java.util.Set;
import java.util.stream.Collectors;

import calculator.constant.DelimiterConstant;

public class RegexGenerator {
	public static String generateExtractNumberRegex(Set<String> customDelimiters){
		return customDelimiters.stream()
			.map(delimiter -> "\\" + delimiter) // 특수문자는 이스케이프 필요
			.collect(Collectors.joining("", DelimiterConstant.REGEX_START_SIGN, DelimiterConstant.REGEX_END_SIGN));
	}
}
