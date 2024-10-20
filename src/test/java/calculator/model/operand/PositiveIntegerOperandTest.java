package calculator.model.operand;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositiveIntegerOperandTest {

    @Nested
    @DisplayName("유효한 경우")
    class ValidCases {

        @Test
        @DisplayName("양수 피연산자들의 합을 올바르게 계산한다")
        void testSumWithPositiveIntegerOperand() {
            // given
            List<Integer> numbers = List.of(1, 2, 3, 4);
            PositiveIntegerOperand operand = new PositiveIntegerOperand(numbers);

            // when & then
            assertThat(operand.sum()).isEqualTo(10);
        }

        @Test
        @DisplayName("양수 피연산자들의 차를 올바르게 계산한다")
        void testSubtractWithPositiveIntegerOperand() {
            // given
            List<Integer> numbers = List.of(10, 3, 2);
            PositiveIntegerOperand operand = new PositiveIntegerOperand(numbers);

            // when & then
            assertThat(operand.subtract()).isEqualTo(5);
        }

        @Test
        @DisplayName("양수 피연산자들의 곱을 올바르게 계산한다")
        void testMultiplyWithPositiveIntegerOperand() {
            // given
            List<Integer> numbers = List.of(2, 3, 4);
            PositiveIntegerOperand operand = new PositiveIntegerOperand(numbers);

            // when & then
            assertThat(operand.multiply()).isEqualTo(24);
        }

        @Test
        @DisplayName("양수 피연산자들의 나눗셈을 올바르게 계산한다")
        void testDivideWithPositiveIntegerOperand() {
            // given
            List<Integer> numbers = List.of(20, 2, 2);
            PositiveIntegerOperand operand = new PositiveIntegerOperand(numbers);

            // when & then
            assertThat(operand.divide()).isEqualTo(5);
        }
    }

    @Nested
    @DisplayName("유효하지 않은 경우")
    class InvalidCases {

        @ParameterizedTest
        @DisplayName("피연산자에 0이나 음수가 포함되면 IllegalArgumentException을 발생시킨다")
        @ValueSource(ints = {0, -1, -5, -10})
        void testZeroOrNegativeOperand(int invalidNumber) {
            // given
            List<Integer> numbers = List.of(10, invalidNumber, 5);

            // when & then
            assertThatThrownBy(() -> new PositiveIntegerOperand(numbers))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
