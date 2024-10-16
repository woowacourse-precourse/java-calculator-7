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

    @Test
    void 정수배열_테스트_콜론() {
        // given & when
        Input input = Input.of("1:2:3");
        // then
        int[] nums = input.getNums();
        assertEquals(1, nums[0]);
        assertEquals(2, nums[1]);
        assertEquals(3, nums[2]);
    }

    @Test
    void 정수배열_테스트_콤마() {
        // given & when
        Input input = Input.of("1,3");
        // then
        int[] nums = input.getNums();
        assertEquals(1, nums[0]);
        assertEquals(3, nums[1]);
    }

    @Test
    void 정수배열_예외_구분자_오류() {
        // given & when
        Input input = Input.of("1,3?2");
        // then
        assertThrows(IllegalArgumentException.class, () -> input.getNums());
    }
}