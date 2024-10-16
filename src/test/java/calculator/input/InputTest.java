package calculator.input;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InputTest {

    @Test
    void 객체_테스트() {
        // given & when
        Input input = Input.of("1;2;3");
        // then
        assertFalse(input instanceof CustomInput);
        assertNotNull(input);
    }
}