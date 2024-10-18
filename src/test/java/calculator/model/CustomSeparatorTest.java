package calculator.model;

import calculator.controller.CalculatorController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
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

    @ParameterizedTest(name = "{index} : {2}")
    @DisplayName("커스텀 구분자 정상 작동 확인")
    @MethodSource("generateSuccessData")
    void testCustomSeparator(String input, List<Integer> output, String message) {
        assertThat(new CalculatorController().getNumbers(input)).isEqualTo(output);
    } // testCustomSeparator

    static Stream<Arguments> generateSuccessData() {
        return Stream.of(
                Arguments.of("//!!\\n1!23", List.of(1, 23), "중복 지정할 때"),
                Arguments.of("//:\\n1:2:3", List.of(1, 2, 3), "기본 구분자를 지정했을 때"),
                Arguments.of("//-\\n1--2", List.of(1, 0, 2), "커스텀 구분자를 연속 입력했을 때"),
                Arguments.of("//;\\n;1;2;", List.of(0, 1, 2), "커스텀 구분자를 계산 부분 앞 뒤에 입력했을 때")
        );
    } // generateSuccessData

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
                Arguments.of("//!@#\\n1!2", "커스텀 구분자의 개수가 2개 초과일 때")
                );
    } // generateExceptionData
} // class