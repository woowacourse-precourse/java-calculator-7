package calculator.model;

import calculator.controller.CalculatorController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("커스텀 구분자 확인")
public class CustomSeparatorTest {
    @Test
    @DisplayName("커스텀 구분자 형식 확인")
    void containsCustomSeparator() {
        assertThat(new CalculatorController().containsCustomSeparator("//!@\\n1!2@3")).isTrue();
    } // containsCustomSeparator

    @ParameterizedTest(name = "{index} : {1}")
    @DisplayName("커스텀 구분자 예외 확인")
    @MethodSource("generateExceptionData")
    void isCustomSeparatorException(String input, String message) {
        assertThatThrownBy(() -> new CustomSeparator().separate(input))
                .isInstanceOf(IllegalArgumentException.class);
    } // isCustomSeparatorException

    static Stream<Arguments> generateExceptionData() {
        return Stream.of(
                Arguments.of("//\\n1234", "공백일 때"),
                Arguments.of("//\\\\n1\\2\\3\\4", "\\일 때"),
                Arguments.of("//0\\n1020304", "숫자일 때"),
                Arguments.of("//!@#\\n1!2", "커스텀 구분자의 개수가 2개 이상일 때")
                );
    } // generateExceptionData
} // class