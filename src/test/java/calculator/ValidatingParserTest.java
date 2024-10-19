package calculator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculator.service.ValidatingParser;

class ValidatingParserTest {

	@DisplayName("커스텀 구분자가 들어간 문자열의 숫자 리스트를 반환한다.")
	@Test
	void validatedNumbersFrom_custom_separator() {
		//given
		ValidatingParser parser = ValidatingParser.create();
		String testInput = "//ak\\n1ak2ak3";
		List<Integer> expectedResult = List.of(1, 2, 3);

		//when
		List<Integer> result = parser.validatedNumbersFrom(testInput);

		//then
		assertThat(result).isEqualTo(expectedResult);
	}

	@DisplayName("기본 구분자가 들어간 문자열의 숫자 리스트를 반환한다.")
	@Test
	void validatedNumbersFrom_default_separator() {
		//given
		ValidatingParser parser = ValidatingParser.create();
		String testInput = "1:2,3:4";
		List<Integer> expectedResult = List.of(1, 2, 3, 4);

		//when
		List<Integer> result = parser.validatedNumbersFrom(testInput);

		//then
		assertThat(result).isEqualTo(expectedResult);
	}

	@DisplayName("빈 문자열 입력 시 [0]을 반환한다.")
	@Test
	void validatedNumbersFrom_empty_input() {
		//given
		ValidatingParser parser = ValidatingParser.create();
		String testInput = "";
		List<Integer> expectedResult = List.of(0);

		//when
		List<Integer> result = parser.validatedNumbersFrom(testInput);

		//then
		assertThat(result).isEqualTo(expectedResult);
	}

	@DisplayName("음수가 들어오면 IllegalArgumentException을 발생시킨다.")
	@Test
	void validatedNumbersFrom_negative_number() {
		//given
		ValidatingParser parser = ValidatingParser.create();
		String testInput = "-1,1,-1,1";

		//when & then
		assertThatThrownBy(() -> parser.validatedNumbersFrom(testInput))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("숫자가 아닌 입력은 IllegalArgumentException을 발생시킨다.")
	@Test
	void validatedNumbersFrom_non_numeric_input() {
		//given
		ValidatingParser parser = ValidatingParser.create();
		String testInput = "A,B,C";

		//when & then
		assertThatThrownBy(() -> parser.validatedNumbersFrom(testInput))
			.isInstanceOf(IllegalArgumentException.class);
	}
}