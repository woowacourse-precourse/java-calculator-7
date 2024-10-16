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

    @Test
    void 문자열_형식_오류_숫자로_시작_안_함() {
        // given
        String inputStr = ";2;3";
        // when & then
        assertThrows(IllegalArgumentException.class, () -> Input.of(inputStr));
    }
}