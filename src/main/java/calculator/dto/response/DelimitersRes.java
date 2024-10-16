package calculator.dto.response;

import java.util.Set;

public record DelimitersRes(
	Set<String> delimiters
){
	public static DelimitersRes from(Set<String> delimiters) {
		return new DelimitersRes(delimiters);
	}
}
