package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class NumberTest {

    @Test
    void 정상_처리() {
        Number number = new Number("1234567890");
        assertEquals(1234567890L, number.getValue());
    }

    @Test
    void 정상_처리2() {
        Number number = new Number("9876543210");
        assertEquals(9876543210L, number.getValue());
    }

    @Test
    void 음수_입력_예외_처리() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Number("-1234567890"));
        assertEquals("음수 입력은 불가합니다.", exception.getMessage());
    }

    @Test
    void 숫자_길이_초과_예외_처리() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Number("12345678901"));
        assertEquals("올바르지 않은 형식입니다. 숫자는 10자리를 넘을 수 없습니다.", exception.getMessage());
    }

    @Test
    void 숫자가_너무_커서_Long_변환_불가() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Number("99999999999999999999"));
        assertEquals("올바르지 않은 형식입니다. 숫자는 10자리를 넘을 수 없습니다.", exception.getMessage());
    }

    @Test
    void 중간에_문자_예외_처리() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Number("12345a7890"));
        assertEquals("올바르지 않은 형식입니다.", exception.getMessage());
    }

    @Test
    void 중간에_하이픈_예외_처리() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Number("1234-567890"));
        assertEquals("올바르지 않은 형식입니다.", exception.getMessage());
    }

    @Test
    void 음수_중간에_하이픈_잘못된_형식_처리_먼저() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Number("-1234-567890"));
        assertEquals("올바르지 않은 형식입니다.", exception.getMessage());
    }
}
