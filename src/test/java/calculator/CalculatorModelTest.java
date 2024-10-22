package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorModelTest {
    private final CalculatorModel calculatorModel = new CalculatorModel();

    @Nested
    class SplitStringTests {
        @Test
        void 빈문자열_0반환() {
            // given
            List<String> expected = List.of("0");
            String input = "";

            // when
            List<String> result = calculatorModel.splitString(input);

            // then
            assertThat(result).isEqualTo(expected);
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3"})
        void 기본_문자열_구분자로_문자열_구분_성공_올바른값_반환(String input) {
            // given
            List<String> expected = List.of("1", "2", "3");

            // when
            List<String> result = calculatorModel.splitString(input);

            // then
            assertThat(result).isEqualTo(expected);
        }

        @ParameterizedTest
        @ValueSource(strings = {"12,32:33123", "1", "1,2:3", "1,2,3,4,5,6,7,8,9,10"})
        void 기본_문자열_구분자로_문자열_구분_성공_예외_발생안함(String input) {
            // when then
            assertThatCode(() -> calculatorModel.splitString(input))
                    .doesNotThrowAnyException();
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,", ",1,2,3", "1,,2,3,", "1,2!3", "잘못 입력"})
        void 문자열_형식오류_예외발생(String input) {
            // when then
            assertThatThrownBy(() -> calculatorModel.splitString(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"//;\\n1;2;3", "//d\\n1d2d3", "//d\\n1d2:3"})
        void 커스텀_문자열_구분자로_문자열_구분_성공(String input) {
            // given
            List<String> expected = List.of("1", "2", "3");

            // when
            List<String> result = calculatorModel.splitString(input);

            // then
            assertThat(result).isEqualTo(expected);
        }

        @ParameterizedTest
        @ValueSource(strings = {"//;1;2;3", ";\\n1;2;3", "//\\n1;2;3", "//1\\n11213", "//da\\n1d2:3"})
        void 커스텀_문자열_형식오류_예외발생(String input) {
            // when then
            assertThatThrownBy(() -> calculatorModel.splitString(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 문자_포함_문자열_구분_실패_예외발생() {
            // given
            String input = "1,a,3";

            // when then
            assertThatThrownBy(() -> calculatorModel.splitString(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"-11,2,3", "31,-2,3", "1,2132,-3"})
        void 음수_포함_문자열_구분_실패_예외발생(String input) {
            // when then
            assertThatThrownBy(() -> calculatorModel.splitString(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class CalculateSumTests {
        @Test
        void 값_더하기_성공() {
            // given
            List<Integer> values = List.of(1, 2, 3);
            int expected = 6;

            // when
            int result = calculatorModel.calculateSum(values);

            // then
            assertThat(result).isEqualTo(expected);
        }
    }
}