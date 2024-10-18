package calculator.input;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InputFilterTest {

    @Test
    void 커스텀_객체_변환() {
        // given
        String customInput = "//;\\n1;2;3";
        // when & then
        assertInstanceOf(CustomInput.class, InputFilter.parseInput(customInput));
    }

    @Test
    void 기본_객체_반환_확인() {
        // given
        String defaultInput = "1,2:3";
        // when
        Input defaultInputInstance = InputFilter.parseInput(defaultInput);
        // then
        assertInstanceOf(Input.class, defaultInputInstance);
        assertFalse(defaultInputInstance instanceof CustomInput);
    }
}