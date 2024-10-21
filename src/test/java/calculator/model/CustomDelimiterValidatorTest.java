package calculator.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomDelimiterValidatorTest {

	@Test
	@DisplayName("커스텀 구분자가 포함되지않는 문자열이 입력되었을 때 기본 생성자로 생성된 StringValidator를 반환한다.")
	void 커스텀_구분자가_포함된_문자열이_입력되지_않았을_때_이를_반영한_문자열_유효성_검사_객체를_반환한다() {
		// given
		CustomDelimiterValidator customDelimiterValidator = new CustomDelimiterValidator();
		String input = "1,2:3";
		String inputExpectedResult = "1,2:3";
		List<Delimiter> delimitersExpectedResult = Stream.of(",", ":")
			.map(Delimiter::new)
			.toList();

		// when
		StringValidator stringValidator = customDelimiterValidator.validCustomDelimiter(input);

		// then
		assertThat(stringValidator.getInput()).isEqualTo(inputExpectedResult);
		assertThat(stringValidator.getDelimiters()).isEqualTo(delimitersExpectedResult);
	}

	@Test
	@DisplayName("커스텀 구분자가 포함된 문자열이 입력되었을 때 커스텀 구분자를 포함하고 커스텀 구분자 지정 문자열이 제거된 StringValidator를 반환한다.")
	void 커스텀_구분자가_포함된_문자열이_입력되었을_때_이를_반영한_문자열_유효성_검사_객체를_반환한다() {
		// given
		CustomDelimiterValidator customDelimiterValidator = new CustomDelimiterValidator();
		String customDelimiter = "#";
		String input = "//#\\n1,2:3#4";
		String inputExpectedResult = "1,2:3#4";
		List<Delimiter> delimitersExpectedResult = Stream.of(",", ":", customDelimiter)
			    .map(Delimiter::new)
			    .toList();

		// when
		StringValidator stringValidator = customDelimiterValidator.validCustomDelimiter(input);

		// then
		assertThat(stringValidator.getInput()).isEqualTo(inputExpectedResult);
		assertThat(stringValidator.getDelimiters()).isEqualTo(delimitersExpectedResult);
	}
}