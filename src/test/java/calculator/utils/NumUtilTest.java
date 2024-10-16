package calculator.utils;

import static org.junit.jupiter.api.Assertions.*;

import calculator.input.Input;
import org.junit.jupiter.api.Test;

class NumUtilTest {

    @Test
    void 숫자인지_검증() {
        // given
        char c = '0';
        // when & then
        for (int i = 0; i < 10; i++) {
            assertTrue(NumUtil.isNum((char) (c + i)));
        }
    }

    @Test
    void 숫자_검증_예외_숫자가_아닌_경우_1() {
        // given
        char invalidChar = '0' - 1;
        // when & then
        assertFalse(NumUtil.isNum(invalidChar));
    }

    @Test
    void 숫자_검증_예외_숫자가_아닌_경우_2() {
        // given
        char invalidChar = '9' + 1;
        // when & then
        assertFalse(NumUtil.isNum(invalidChar));
    }

    @Test
    void nums_의_첫번째_문자가_숫자인지_검증() {
        // given
        String nums = "1:2";
        // when & then
        assertTrue(NumUtil.isValidFirstNum(nums));
    }

    @Test
    void nums_검증_예외_첫번째_문자가_숫자가_아닌_경우() {
        // given
        String invalidNums = ":2";
        // when & then
        assertFalse(NumUtil.isValidFirstNum(invalidNums));
    }

    @Test
    void nums_검증_예외_빈_문자열인_경우() {
        // given
        String emptyNums = "";
        // when & then
        assertTrue(NumUtil.isValidFirstNum(emptyNums)); // 통과
    }

    @Test
    void char_을_정수로_변환() {
        // given
        char c = '0';
        // when & then
        for (int i = 0; i < 10; i++) {
            assertEquals(i, NumUtil.toInt((char) (c + i)));
        }
    }

    @Test
    void 정수_변환_예외_숫자가_아닌_경우1() {
        // given
        char invalidChar = '0' - 1;
        // when & then
        assertThrows(IllegalArgumentException.class, () -> NumUtil.toInt(invalidChar));
    }

    @Test
    void 정수_변환_예외_숫자가_아닌_경우2() {
        // given
        char invalidChar = '9' + 1;
        // when & then
        assertThrows(IllegalArgumentException.class, () -> NumUtil.toInt(invalidChar));
    }

    @Test
    void 정수배열_테스트() {
        // given & when
        int[] nums = NumUtil.toIntArray(Input.of("//;\\n1;2;3"));
        // then
        assertEquals(1, nums[0]);
        assertEquals(2, nums[1]);
        assertEquals(3, nums[2]);
    }

    @Test
    void 정수배열_예외_구분자_다름() {
        // given
        Input input = Input.of("//;\\n1?2");
        // when & then
        assertThrows(IllegalArgumentException.class, () -> NumUtil.toIntArray(input));
    }

    @Test
    void 정수배열_예외_기본_구분자_오류() {
        // given & when
        Input input = Input.of("1,3?2");
        // then
        assertThrows(IllegalArgumentException.class, () ->  NumUtil.toIntArray(input));
    }

    @Test
    void 정수배열_테스트_콜론() {
        // given & when
        int[] nums = NumUtil.toIntArray(Input.of("1:2:3"));
        // then
        assertEquals(1, nums[0]);
        assertEquals(2, nums[1]);
        assertEquals(3, nums[2]);
    }

    @Test
    void 정수배열_테스트_콤마() {
        // given & when
        int[] nums = NumUtil.toIntArray(Input.of("1,3"));
        // then
        assertEquals(1, nums[0]);
        assertEquals(3, nums[1]);
    }
}