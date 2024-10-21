package calculator.utilsTest;

import calculator.model.CalculatorValues;
import calculator.utils.IntegerExtractor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerExtractorTest {
    private CalculatorValues calculatorValues;

    @BeforeEach
    void setUp() {
        calculatorValues = new CalculatorValues();  // 테스트용 CalculatorValues 초기화
    }

    @Test
    void testExtractIntegerWithDefaultDelimiter() {
        // 기본 구분자 ",|:"을 사용하는 경우
        calculatorValues.setExpression("1,2:3");
        calculatorValues.setDelimiter("[,:]");

        IntegerExtractor.extractIntegerFromExpression(calculatorValues);

        assertEquals(3, calculatorValues.getNumbers().size());  // 3개의 숫자가 추가되어야 함
        assertTrue(calculatorValues.getNumbers().contains(BigDecimal.valueOf(1)));
        assertTrue(calculatorValues.getNumbers().contains(BigDecimal.valueOf(2)));
        assertTrue(calculatorValues.getNumbers().contains(BigDecimal.valueOf(3)));
    }

    @Test
    void testExtractIntegerWithCustomDelimiter() {
        // 커스텀 구분자 ";"을 사용하는 경우
        calculatorValues.setExpression("1;2;3");
        calculatorValues.setDelimiter("[,:]");

        IntegerExtractor.extractIntegerFromExpression(calculatorValues);

        assertEquals(3, calculatorValues.getNumbers().size());  // 3개의 숫자가 추가되어야 함
        assertTrue(calculatorValues.getNumbers().contains(BigDecimal.valueOf(1)));
        assertTrue(calculatorValues.getNumbers().contains(BigDecimal.valueOf(2)));
        assertTrue(calculatorValues.getNumbers().contains(BigDecimal.valueOf(3)));
    }

    @Test
    void testExtractIntegerWithDotDelimiter() {

        calculatorValues.setExpression("1.2.3");
        calculatorValues.setDelimiter("[,:]");

        assertThrows(IllegalArgumentException.class, () -> {
            IntegerExtractor.extractIntegerFromExpression(calculatorValues);
        }, "INVALID_NEGATIVE_INTEGER 예외가 발생해야 합니다.");
    }

    @Test
    void testExtractEmptyExpression() {
        // 빈 수식을 입력한 경우
        calculatorValues.setExpression("");
        calculatorValues.setDelimiter("[,:]");

        IntegerExtractor.extractIntegerFromExpression(calculatorValues);

        assertEquals(1, calculatorValues.getNumbers().size());
    }
}
