package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class NumberTest {

    @Test
    void 객체_생성_테스트() {
        Number number = new Number(5);
        assertEquals(5, number.value());
    }

    @Test
    void 덧셈_테스트() {
        Number a = new Number(5);
        Number b = new Number(3);
        Number result = a.add(b);
        assertEquals(8, result.value());
    }

    @Test
    void toString_테스트() {
        Number number = new Number(10);
        assertEquals("10", number.toString());
    }

    @Test
    void 동등성_비교_테스트() {
        Number a = new Number(5);
        Number b = new Number(5);
        Number c = new Number(6);

        assertEquals(a, b);
        assertNotEquals(a, c);
    }

    @Test
    void 해시코드_테스트() {
        Number a = new Number(5);
        Number b = new Number(5);

        assertEquals(a.hashCode(), b.hashCode());
    }
}