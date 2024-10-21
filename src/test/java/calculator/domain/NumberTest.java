package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NumberTest {

    @Test
    void 숫자_읽기() {
        Number n = new Number(5);
        assertEquals(5, n.getNumber());
    }
}
