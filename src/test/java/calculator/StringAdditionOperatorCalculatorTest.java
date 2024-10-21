package calculator;

import calculator.operator.AdditionOperator;
import calculator.operator.Operator;
import calculator.parser.DelimiterConfig;
import calculator.parser.StringDelimiterParser;
import calculator.parser.Parser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class StringAdditionOperatorCalculatorTest {

    private final Parser parser = new StringDelimiterParser(DelimiterConfig.DEFAULT);
    private final Operator operator = new AdditionOperator();
    private final StringAdditionCalculator calculator = new StringAdditionCalculator(operator, parser);

    @Test
    @DisplayName("유효한 입력 문자열에 대한 계산 테스트")
    void success_calculateWithValidInput() {
        // given
        String input = "1,2:3";

        // when
        BigDecimal result = calculator.calculate(input);

        // then
        assertEquals(new BigDecimal("6"), result);
    }

    @Test
    @DisplayName("빈 문자열에 대한 계산 테스트")
    void success_calculateWithEmptyString() {
        // given
        String input = "";

        // when
        BigDecimal result = calculator.calculate(input);

        // then
        assertEquals(BigDecimal.ZERO, result);
    }

    @Test
    @DisplayName("음수가 포함된 입력 문자열에 대한 예외 테스트")
    void fail_calculateWithNegativeNumber() {
        // given
        String input = "1,-2,3";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(input), "양수만 가능합니다.");
    }

    @Test
    @DisplayName("잘못된 숫자 형식이 포함된 입력 문자열에 대한 예외 테스트")
    void fail_calculateWithInvalidNumberFormat() {
        // given
        String input = "1,a,3";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(input), "숫자 입력만 가능합니다.");
    }

    @Test
    @DisplayName("소수 값을 포함한 입력 문자열에 대한 계산 테스트")
    void success_calculateWithDecimalValues() {
        // given
        String input = "0.1,0.2";

        // when
        BigDecimal result = calculator.calculate(input);

        // then
        assertEquals(new BigDecimal("0.3"), result);
    }

    @Test
    @DisplayName("커스텀 구분자가 포함된 입력 문자열에 대한 계산 테스트")
    void success_customDelimiter() {
        // given
        String input = "//;\\n1;2;3";

        // when
        BigDecimal result = calculator.calculate(input);

        // then
        assertEquals(new BigDecimal("6"), result);
    }

    @Test
    @DisplayName("커스텀, 기본 구분자가 포함된 입력 문자열에 대한 계산 테스트")
    void success_mixDelimiter() {
        // given
        String input = "//#\\n1,2:3#4.1";

        // when
        BigDecimal result = calculator.calculate(input);

        // then
        assertEquals(new BigDecimal("10.1"), result);
    }

    @Test
    @DisplayName("여러 구분자가 포함된 입력 문자열에 대한 계산 테스트")
    void testMultipleDelimiters() {
        // given
        String input = "1,2:3";

        // when
        BigDecimal result = calculator.calculate(input);

        // then
        assertEquals(new BigDecimal("6"), result);
    }

    @Test
    @DisplayName("단일 값 입력 문자열에 대한 계산 테스트")
    void testSingleValue() {
        // given
        String input = "5";

        // when
        BigDecimal result = calculator.calculate(input);

        // then
        assertEquals(new BigDecimal("5"), result);
    }
}