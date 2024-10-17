package calculator.service;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NumberTest {

    @Test
    void 숫자포함() {
        Assertions.assertThatThrownBy(() -> new Number("2131232w"));
        Assertions.assertThatThrownBy(() -> new Number("qwe"));
        Assertions.assertThatThrownBy(() -> new Number("2131232w"));
    }

    @Test
    void 음수() {
        Assertions.assertThatThrownBy(() -> new Number("-2131232w"));
    }

    @ParameterizedTest
    @MethodSource("덧셈데이터")
    void 덧셈(final String num1, final String num2, final String result) {
        final Number number1 = new Number(num1);
        final Number number2 = new Number(num2);
        final Number expectedResult = new Number(result);
        Assertions.assertThat(number1.add(number2))
                .isEqualTo(expectedResult);
    }

    static Stream<Arguments> 덧셈데이터() {
        return Stream.of(
                Arguments.of(
                        "12133","45729","57862"
                ),
                Arguments.of(
                        "9999129129","018292832","10017421961"
                )
        );
    }
}