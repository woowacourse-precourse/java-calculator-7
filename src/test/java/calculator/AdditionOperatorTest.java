package calculator;

import calculator.operator.AdditionOperator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class AdditionOperatorTest {

    @Test
    @DisplayName("유효한 입력 값에 대한 덧셈 테스트")
    void success_additionWithValidInput() {
        // given
        BigDecimal[] numbers = {new BigDecimal("1"), new BigDecimal("2"), new BigDecimal("3")};
        AdditionOperator additionOperator = new AdditionOperator();

        // when
        BigDecimal result = additionOperator.calculate(numbers);

        // then
        assertEquals(new BigDecimal("6"), result);
    }

    @Test
    @DisplayName("소수 값을 포함한 유효한 입력 값에 대한 덧셈 테스트")
    void success_additionWithDecimalValues() {
        // given
        BigDecimal[] numbers = {new BigDecimal("0.1"), new BigDecimal("0.2"), new BigDecimal("0.3")};
        AdditionOperator additionOperator = new AdditionOperator();

        // when
        BigDecimal result = additionOperator.calculate(numbers);

        // then
        assertEquals(new BigDecimal("0.6"), result);
    }

    @Test
    @DisplayName("음수가 포함된 입력 값에 대한 예외 테스트")
    void fail_additionWithNegativeNumber() {
        // given
        BigDecimal[] numbers = {new BigDecimal("1"), new BigDecimal("-2.1"), new BigDecimal("3")};
        AdditionOperator additionOperator = new AdditionOperator();

        // when & then
        assertThrows(IllegalArgumentException.class, () -> additionOperator.calculate(numbers), "양수만 가능합니다.");
    }

    @Test
    @DisplayName("단일 값 입력에 대한 덧셈 테스트")
    void success_additionWithSingleValue() {
        // given
        BigDecimal[] numbers = {new BigDecimal("5")};
        AdditionOperator additionOperator = new AdditionOperator();

        // when
        BigDecimal result = additionOperator.calculate(numbers);

        // then
        assertEquals(new BigDecimal("5"), result);
    }
}