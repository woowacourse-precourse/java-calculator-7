package calculator.validation;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @DisplayName("입력값이 비어있을 경우 예외를 던진다")
    @ParameterizedTest
    @MethodSource("invalidInputData")
    void validateInput(String text) {
        assertThatIllegalArgumentException().isThrownBy(() -> inputValidator.validateInput(text))
                .withMessage("입력값이 비어있습니다.");
    }

    @DisplayName("잘못된 구분자 사용 시 예외를 던진다")
    @ParameterizedTest
    @MethodSource("invalidDelimiterData")
    void validateInvalidDelimiter(String text, String validDelimiters) {
        assertThatIllegalArgumentException().isThrownBy(() -> inputValidator.validateInvalidDelimiter(text, validDelimiters))
                .withMessage("유효하지 않은 구분자가 사용되었습니다.");
    }

    @DisplayName("커스텀 구분자가 숫자일 경우 예외를 던진다")
    @ParameterizedTest
    @MethodSource("invalidCustomDelimiterData")
    void validateCustomDelimiterWithNumber(String customDelimiter) {
        assertThatIllegalArgumentException().isThrownBy(() -> inputValidator.validateCustomDelimiter(customDelimiter))
                .withMessage("커스텀 구분자에 숫자는 입력할 수 없습니다.");
    }

    @DisplayName("커스텀 구분자가 여러 개일 경우 예외를 던진다")
    @ParameterizedTest
    @MethodSource("invalidMultipleCustomDelimiterData")
    void validateMultipleCustomDelimiter(String customDelimiter) {
        assertThatIllegalArgumentException().isThrownBy(() -> inputValidator.validateCustomDelimiter(customDelimiter))
                .withMessage("커스텀 구분자는 한가지만 지정할 수 있습니다.");
    }

    @DisplayName("음수 또는 0이 포함된 숫자일 경우 예외를 던진다")
    @ParameterizedTest
    @MethodSource("invalidNumberData")
    void validateNegativeOrZeroNumber(String number) {
        assertThatIllegalArgumentException().isThrownBy(() -> inputValidator.validatePositiveNumber(number))
                .withMessage("음수나 0은 입력할 수 없습니다.");
    }

    @DisplayName("잘못된 형식의 숫자일 경우 예외를 던진다")
    @ParameterizedTest
    @MethodSource("invalidNumberFormatData")
    void validateInvalidNumberFormat(String number) {
        assertThatIllegalArgumentException().isThrownBy(() -> inputValidator.validatePositiveNumber(number))
                .withMessage("유효하지 않은 숫자가 사용되었습니다.");
    }

    static Stream<Arguments> invalidInputData() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of("   ")
        );
    }

    static Stream<Arguments> invalidDelimiterData() {
        return Stream.of(
                Arguments.of("1,2;3", ",|:"),
                Arguments.of("1|2;3", ",|:")
        );
    }

    static Stream<Arguments> invalidCustomDelimiterData() {
        return Stream.of(
                Arguments.of("1"),
                Arguments.of("2")
        );
    }

    static Stream<Arguments> invalidMultipleCustomDelimiterData() {
        return Stream.of(
                Arguments.of(";;"),
                Arguments.of("ab")
        );
    }

    static Stream<Arguments> invalidNumberData() {
        return Stream.of(
                Arguments.of("-1"),
                Arguments.of("0")
        );
    }

    static Stream<Arguments> invalidNumberFormatData() {
        return Stream.of(
                Arguments.of("abc"),
                Arguments.of("1.5")
        );
    }
}
