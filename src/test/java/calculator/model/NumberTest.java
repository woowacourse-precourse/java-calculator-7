package calculator.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumberTest {

    @Test
    void 유효한_숫자_문자열로_Number_객체를_생성한다() {
        Number number = Number.from("5.25");
        assertEquals("5.25", number.toString());
    }

    @Test
    void 문자열로_Number_객체를_생성하면_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class, () ->
                Number.from("숫자가 아님"));
    }

    @Test
    void 소수를_가장한_숫자로_Number_객체를_생성하면_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class, () ->
                Number.from("1.0.0"));
    }

    @Test
    void 두_Number_객체를_더한다() {
        Number num1 = Number.from("2.5");
        Number num2 = Number.from("3.7");
        assertEquals("6.2", num1.add(num2).toString());
    }

    @Test
    void 정수_값은_소수점_없이_출력된다() {
        Number number = Number.from("5.00");
        assertEquals("5", number.toString());
    }

    @Test
    void 소수_값은_소수점과_함께_출력된다() {
        Number number = Number.from("5.20");
        assertEquals("5.2", number.toString());
    }
}