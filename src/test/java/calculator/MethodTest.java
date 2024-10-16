package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MethodTest {

    @Test
    @DisplayName("입력값이 정상적으로 들어오게 되는지")
    void test() {
        String given = "1:2:3";
        String expected = "1:2:3";

        System.setIn(new ByteArrayInputStream(given.getBytes()));

        String result = Application.getInput();

        assertEquals(expected, result);
    }
}
