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

@DisplayName("기본 구분자 확인")
class DefaultSeparatorTest {
    @Test
    @DisplayName("기본 구분자 포함 확인")
    void containsDefaultSeparator() {
        assertThat(new CalculatorController().containsDefaultSeparator("1:2:3")).isTrue();
    } // containsDefaultSeparator

    @ParameterizedTest(name = "{index} : {2}")
    @DisplayName("기본 구분자 정상 작동 확인")
    @MethodSource("generateSuccessData")
    void testDefaultSeparator(String input, List<Integer> output,String message) {
        assertThat(new CalculatorController().getNumbers(input)).isEqualTo(output);
    } // testDefaultSeparator

    static Stream<Arguments> generateSuccessData() {
        return Stream.of(
                Arguments.of("1::2:3", List.of(1, 0, 2, 3), "기본 구분자를 연속 입력했을 때"),
                Arguments.of(",1,2,3,", List.of(0, 1, 2, 3), "기본 구분자를 계산 부분 앞 뒤에 입력했을 때")
        );
    } // generateSuccessData

    @Test
    @DisplayName("기본 구분자 예외 확인")
    void isDefaultSeparatorException() {
        assertThatThrownBy(() -> new DefaultSeparator().separate("1,2!3"))
                .isInstanceOf(IllegalArgumentException.class);
    } // isDefaultSeparatorException
} // class