package calculator.model.operand;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class IntegerOperandTest {

    @Nested
    @DisplayName("유효한 경우")
    class ValidCases {

        @Test
        @DisplayName("양수와 음수가 포함된 피연산자들의 합을 올바르게 계산한다")
        void testSumWithIntegerOperand() {
            // given
            List<Integer> numbers = List.of(1, -2, 3, -4);
            IntegerOperand operand = new IntegerOperand(numbers);

            // when & then
            assertThat(operand.sum()).isEqualTo(-2);
        }

        @Test
        @DisplayName("양수와 음수가 포함된 피연산자들의 차를 올바르게 계산한다")
        void testSubtractWithIntegerOperand() {
            // given
            List<Integer> numbers = List.of(10, -3, -2);
            IntegerOperand operand = new IntegerOperand(numbers);

            // when & then
            assertThat(operand.subtract()).isEqualTo(15);
        }

        @Test
        @DisplayName("양수와 음수가 포함된 피연산자들의 곱을 올바르게 계산한다")
        void testMultiplyWithIntegerOperand() {
            // given
            List<Integer> numbers = List.of(-2, 3, -4);
            IntegerOperand operand = new IntegerOperand(numbers);

            // when & then
            assertThat(operand.multiply()).isEqualTo(24);
        }

        @Test
        @DisplayName("양수와 음수가 포함된 피연산자들의 나눗셈을 올바르게 계산한다")
        void testDivideWithIntegerOperand() {
            // given
            List<Integer> numbers = List.of(-20, 2, -2);
            IntegerOperand operand = new IntegerOperand(numbers);

            // when & then
            assertThat(operand.divide()).isEqualTo(5);
        }
    }

    @Nested
    @DisplayName("유효하지 않은 경우")
    class InvalidCases {

        @Test
        @DisplayName("피연산자가 비어있으면 IllegalArgumentException을 발생시킨다")
        void testEmptyOperand() {
            // given
            List<Integer> numbers = List.of();

            // given & when & then
            assertThatThrownBy(() -> new IntegerOperand(numbers))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("나눗셈에서 0으로 나누면 ArithmeticException을 발생시킨다")
        void testDivideByZero() {
            // given
            List<Integer> numbers = List.of(10, 2, 0);
            IntegerOperand operand = new IntegerOperand(numbers);

            // when & then
            assertThatThrownBy(operand::divide)
                    .isInstanceOf(ArithmeticException.class);
        }
    }
}
