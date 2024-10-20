package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class DefaultInputTest {
    @Test
    void 기본구분자로_성공() {
        Input input = new Input("10:3,9");
        assertEquals("10:3,9", input.getStr());
        assertEquals(",|:", input.getStr());
    }

}