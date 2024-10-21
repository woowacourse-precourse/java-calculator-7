package calculator.model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringValidatorTest {

	private final String errorMessage = "잘못된 문자열 형식입니다.";

	@ParameterizedTest
	@DisplayName("기본 문자열이 입력되었을 때 에러 없이 이를 검증한다.")
	@ValueSource(strings = {"1,2:3", "1,2,3", "1:2:3"})
	void 기본_문자열이_입력되었을_때_검증한다(String input) {
		// given
		StringValidator stringValidator = new StringValidator(input);

		// when, then
		assertThatCode(stringValidator::validate).doesNotThrowAnyException();
	}

	@ParameterizedTest
	@DisplayName("커스텀 구분자가 포함된 문자열이 입력되었을 때 에러 없이 이를 검증한다.")
	@ValueSource(strings = {"//#\\n1,2:3#4", "//?\\n1?2?3", "//\\\n1\\2\\3"})
	void 커스텀_구분자가_포함된_문자열이_입력되었을_때_검증한다(String input) {
		// given
		int customDelimiterIndex = 2;
		int customDelimiterLength = 1;
		int specifiedCustomDelimiterLength = 5;
		String customDelimiter = input.substring(customDelimiterIndex, customDelimiterIndex + customDelimiterLength);
		String customDelimiterRemovedInput = input.substring(specifiedCustomDelimiterLength);
		StringValidator stringValidator = new StringValidator(customDelimiterRemovedInput, customDelimiter);

		// when, then
		assertThatCode(stringValidator::validate).doesNotThrowAnyException();
	}

	@Test
	@DisplayName("빈 문자열이 입력되었을 때 에러 없이 이를 검증한다.")
	void 빈_문자열이_입력되었을_때_검증한다() {
		// given
		String input = "";
		StringValidator stringValidator = new StringValidator(input);

		// when, then
		assertThatCode(stringValidator::validate).doesNotThrowAnyException();
	}

	@ParameterizedTest
	@DisplayName("구분자가 존재하지 않는 문자열이 입력되었을 때 에러 없이 이를 검증한다.")
	@ValueSource(strings = {"1", "12", "123"})
	void 구분자가_존재하지_않는_문자열이_입력되었을_때_검증한다(String input) {
		// given
		StringValidator stringValidator = new StringValidator(input);

		// when, then
		assertThatCode(stringValidator::validate).doesNotThrowAnyException();
	}

	@Test
	@DisplayName("음수가 포함된 문자열이 입력되었을 때 에러를 발생시킨다.")
	void 음수가_포함된_문자열이_입력되었을_때_에러를_발생시킨다() {
		// given
		String input = "-1,2,3";
		StringValidator stringValidator = new StringValidator(input);

		// when, then
		assertThatThrownBy(stringValidator::validate)
		        .isInstanceOf(IllegalArgumentException.class)
				.hasMessage(errorMessage);
	}

	@ParameterizedTest
	@DisplayName("구분자가 중복된 문자열이 입력되었을 때 에러를 발생시킨다.")
	@ValueSource(strings = {"1,,2", "1::2", "1,2:3,:4"})
	void 구분자가_중복된_문자열이_입력되었을_때_에러를_발생시킨다(String input) {
		// given
		StringValidator stringValidator = new StringValidator(input);

		// when, then
		assertThatThrownBy(stringValidator::validate)
			    .isInstanceOf(IllegalArgumentException.class)
			    .hasMessage(errorMessage);
	}

	@ParameterizedTest
	@DisplayName("존재하지 않는 구분자가 포함된 문자열이 입력되었을 때 에러를 발생시킨다.")
	@ValueSource(strings = {"1;2", "1,2;3", "1,2:3#4"})
	void 존재하지_않는_구분자가_포함된_문자열이_입력되었을_때_에러를_발생시킨다(String input) {
		// given
		StringValidator stringValidator = new StringValidator(input);

		// when, then
		assertThatThrownBy(stringValidator::validate)
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage(errorMessage);
	}
}