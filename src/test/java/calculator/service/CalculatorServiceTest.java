package calculator.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.dto.CalculatorRequestDto;
import calculator.dto.CalculatorResponseDto;
import calculator.exception.CalculatorException;
import calculator.exception.constants.ErrorMessage;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest(name = "입력값: {0}, 기대값: {1}")
    @MethodSource("provideInputWithDefaultDelimiterAndPositiveNumber")
    void 입력_값이_기본_구분자이고_양수일_때_더하기(String input, long expected) {
        // given
        CalculatorRequestDto requestDto = new CalculatorRequestDto(input);

        // when
        CalculatorResponseDto responseDto = calculatorService.sum(requestDto);
        long sumResult = responseDto.sumResult();

        // then
        assertThat(sumResult).isEqualTo(expected);
    }

    @ParameterizedTest(name = "입력값: {0}, 기대값: {1}")
    @MethodSource("provideInputWithCustomDelimiterAndPositiveNumber")
    void 입력_값이_커스텀_구분자이고_양수일_때_더하기(String input, long expected) {
        // given
        CalculatorRequestDto requestDto = new CalculatorRequestDto(input);

        // when
        CalculatorResponseDto responseDto = calculatorService.sum(requestDto);
        long sumResult = responseDto.sumResult();

        // then
        assertThat(sumResult).isEqualTo(expected);
    }

    @ParameterizedTest(name = "입력값: {0}")
    @ValueSource(strings = {"a", "1.2", "a,b", "1,a,3", "1.2,2,3"})
    void 입력_값이_기본_구분자이고_문자_또는_실수가_포함_된_경우(String input) {
        // given
        CalculatorRequestDto requestDto = new CalculatorRequestDto(input);

        // when & then
        assertThatThrownBy(() -> calculatorService.sum(requestDto))
                .isInstanceOf(CalculatorException.class)
                .hasMessage(ErrorMessage.INVALID_INPUT_VALUE.getMessage());
    }

    @ParameterizedTest(name = "입력값: {0}")
    @ValueSource(strings = {"//;\\na", "//@\\n1.2", "//#\\na#b", "//;\\n1;a;3", "// \\n1.2 2 3"})
    void 입력_값이_커스텀_구분자이고_문자_또는_실수가_포함_된_경우(String input) {
        // given
        CalculatorRequestDto requestDto = new CalculatorRequestDto(input);

        // when & then
        assertThatThrownBy(() -> calculatorService.sum(requestDto))
                .isInstanceOf(CalculatorException.class)
                .hasMessage(ErrorMessage.INVALID_INPUT_VALUE.getMessage());
    }

    @ParameterizedTest(name = "입력값: {0}")
    @ValueSource(strings = {"-1", "0", "0,1", "-1,2,3", "-1,-2,-3"})
    void 입력_값이_기본_구분자이고_양수가_아닌_수가_포함_된_경우(String input) {
        // given
        CalculatorRequestDto requestDto = new CalculatorRequestDto(input);

        // when & then
        assertThatThrownBy(() -> calculatorService.sum(requestDto))
                .isInstanceOf(CalculatorException.class)
                .hasMessage(ErrorMessage.NEGATIVE_VALUE_NOT_ALLOWED.getMessage());
    }

    @ParameterizedTest(name = "입력값: {0}")
    @ValueSource(strings = {"//;\\n-1", "//@\\n0", "//#\\n0#1", "//ab\\n-1ab2ab3", "// \\n-1 -2 -3"})
    void 입력_값이_커스텀_구분자이고_양수가_아닌_수가_포함_된_경우(String input) {
        // given
        CalculatorRequestDto requestDto = new CalculatorRequestDto(input);

        // when & then
        assertThatThrownBy(() -> calculatorService.sum(requestDto))
                .isInstanceOf(CalculatorException.class)
                .hasMessage(ErrorMessage.NEGATIVE_VALUE_NOT_ALLOWED.getMessage());
    }

    @Test
    void 입력_값이_빈_값일_경우() {
        // given
        String input = "";
        CalculatorRequestDto requestDto = new CalculatorRequestDto(input);

        // when
        CalculatorResponseDto responseDto = calculatorService.sum(requestDto);
        long sumResult = responseDto.sumResult();

        // then
        assertThat(sumResult).isZero();
    }

    @Test
    void 입력_값이_커스텀_구분자이고_빈_값일_경우() {
        // given
        String input = "//;\\n";
        CalculatorRequestDto requestDto = new CalculatorRequestDto(input);

        // when & then
        assertThatThrownBy(() -> calculatorService.sum(requestDto))
                .isInstanceOf(CalculatorException.class)
                .hasMessage(ErrorMessage.INVALID_INPUT_VALUE.getMessage());
    }

    static Stream<Arguments> provideInputWithDefaultDelimiterAndPositiveNumber() {
        return Stream.of(
                Arguments.of("1", 1L),
                Arguments.of("1,2", 3L),
                Arguments.of("1:2", 3L),
                Arguments.of("1,2,3", 6L),
                Arguments.of("1,2:3", 6L),
                Arguments.of("1:2:3", 6L)
        );
    }

    static Stream<Arguments> provideInputWithCustomDelimiterAndPositiveNumber() {
        return Stream.of(
                Arguments.of("//;\\n1", 1L),
                Arguments.of("//!\\n1!2", 3L),
                Arguments.of("//@\\n1@2@3", 6L),
                Arguments.of("//asd\\n1asd2asd3", 6L),
                Arguments.of("//0\\n10203", 6L),
                Arguments.of("// \\n1 2 3", 6L),
                Arguments.of("//\b\\n1\b2\b3", 6L),
                Arguments.of("//\n\\n1\n2\n3", 6L),
                Arguments.of("//,\\n1,2,3", 6L)
        );
    }
}