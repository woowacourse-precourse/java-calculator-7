package calculator.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("입력값 확인")
class InputValidatorTest {
    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    } // setUp

    @ParameterizedTest(name = "{index} : {2}")
    @DisplayName("입력값 확인")
    @MethodSource("generateData")
    void inputTest(String input, int output, String message) {
        assertThat(inputValidator.validate(input)).isEqualTo(output);
    } // inputTest

    private static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(null, 0, "null 입력"),
                Arguments.of("", 0, "공백 입력"),
                Arguments.of(" ", 0, "white space 입력"),
                Arguments.of("1", 1, "숫자 1만 입력")
        );
    } // generateData

    @ParameterizedTest(name = "{index} : {1}")
    @DisplayName("입력값 예외 확인")
    @MethodSource("generateExceptionData")
    void inputExceptionTest(String input, String message) {
        assertThatThrownBy(() -> inputValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    } // inputExceptionTest

    private static Stream<Arguments> generateExceptionData() {
        return Stream.of(
                Arguments.of(";123", "숫자만으로 구성되지 않았을 때"),
                Arguments.of("-2", "음수일 때")
                );
    } // generateExceptionData
} // class