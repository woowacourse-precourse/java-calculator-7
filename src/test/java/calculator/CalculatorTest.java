package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void 잘못된_커스텀_구분자_사용() {

        // given
        String input = "//;\1;2;3";

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator calculator = new Calculator();
            calculator.calculate(input);  // 예외가 발생해야 함
        });

        // then
        assertEquals("유효하지 않은 커스텀 구분자 형식입니다.", exception.getMessage());
    }
}