package calculator.dto.response;

import java.util.Set;

public record DelimitersDto(
	Set<String> delimiters
){
	public static DelimitersDto from(Set<String> delimiters) {
		return new DelimitersDto(delimiters);
	}
}
