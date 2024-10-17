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

    @Test
    void 커스텀_객체_변환_예외_숫자로_시작_안_함() {
        // given
        String customInput = "//;\\n" + ";2;3";
        // when & then
        assertThrows(IllegalArgumentException.class, () -> InputFilter.parseInput(customInput));
    }

    @Test
    void 커스텀_객체_변환_예외_구분자_없음() {
        // given
        String customInput = "//\\n" + "1;2;3";
        // when & then
        assertThrows(IllegalArgumentException.class, () -> InputFilter.parseInput(customInput));
    }

    @Test
    void 커스텀_객체_변환_예외_prefix_없음() {
        // given
        String customInput = ";\\" + "n1;2;3";
        // when & then
        assertThrows(IllegalArgumentException.class, () -> InputFilter.parseInput(customInput));
    }

    @Test
    void 커스텀_객체_변환_예외_suffix_없음() {
        // given
        String customInput = "//;" + "1;2;3";
        // when & then
        assertThrows(IllegalArgumentException.class, () -> InputFilter.parseInput(customInput));
    }

    @Test
    void 기본_객체_변환_예외_숫자로_시작_안_함() {
        // given
        String defaultInput = ";2;3";
        // when & then
        assertThrows(IllegalArgumentException.class, () -> InputFilter.parseInput(defaultInput));
    }
}