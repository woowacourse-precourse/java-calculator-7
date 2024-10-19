package calculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculationStringTest {

    @Test
    void 빈_문자열은_기본값_0_반환() {
        CalculationString calculationString = new CalculationString("");
        String result = calculationString.getString();
        assertEquals("0", result);
    }

    @Test
    void 공백_문자열은_기본값_0_반환() {
        CalculationString calculationString = new CalculationString("   ");
        String result = calculationString.getString();
        assertEquals("0", result);
    }

    @Test
    void 유효한_문자열_그대로_반환() {
        CalculationString calculationString = new CalculationString("1,2:3");
        String result = calculationString.getString();
        assertEquals("1,2:3", result);
    }

    @Test
    void 커스텀_구분자_문자열_그대로_반환() {
        CalculationString calculationString = new CalculationString("//;\n1;2;3");
        String result = calculationString.getString();
        assertEquals("//;\n1;2;3", result);
    }

    @Test
    void 유효한_숫자_문자열_그대로_반환() {
        CalculationString calculationString = new CalculationString("123");
        String result = calculationString.getString();
        assertEquals("123", result);
    }
}
