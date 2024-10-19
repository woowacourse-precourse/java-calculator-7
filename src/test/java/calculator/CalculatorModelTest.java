package calculator;

import static org.assertj.core.api.Assertions.assertThat;
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
        @ParameterizedTest
        @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3"})
        void 기본_문자열_구분자로_문자열_구분_성공(String input) {
            // given
            List<Integer> expected = List.of(1, 2, 3);

            // when
            List<Integer> result = calculatorModel.splitString(input);

            // then
            assertThat(result).isEqualTo(expected);
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,", ",1,2,3", "1,,2,3,", "1,2!3", "잘못 입력"})
        void 문자열_형식오류_예외발생(String input) {
            // when then
            assertThatThrownBy(() -> calculatorModel.splitString(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"//;\\n1;2;3", "//d\\n1d2d3", "//d\\n1d2;3"})
        void 커스텀_문자열_구분자로_문자열_구분_성공(String input) {
            // given
            List<Integer> expected = List.of(1, 2, 3);

            // when
            List<Integer> result = calculatorModel.splitString(input);

            // then
            assertThat(result).isEqualTo(expected);
        }

        @ParameterizedTest
        @ValueSource(strings = {"//;1;2;3", ";\\n1;2;3", "//\\n1;2;3", "//1\\n11213"})
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

        @Test
        void 음수_포함_문자열_구분_실패_예외발생() {
            // given
            String input = "-1,2,3";

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