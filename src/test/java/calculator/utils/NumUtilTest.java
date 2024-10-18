package calculator.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumUtilTest {

    @Test
    void 숫자인지_검증() {
        // given
        char c = '0';
        // when & then
        for (int i = 0; i < 10; i++) {
            assertTrue(NumUtil.isNum(String.valueOf((char) (c + i))));
        }
    }

    @Test
    void 숫자_검증_예외_숫자가_아닌_경우_1() {
        // given
        String invalidChar = "1.";
        // when & then
        assertFalse(NumUtil.isNum(invalidChar));
    }

    @Test
    void 숫자_검증_예외_숫자가_아닌_경우_2() {
        // given
        String invalidChar = "3,2";
        // when & then
        assertFalse(NumUtil.isNum(invalidChar));
    }

    @Test
    void nums_의_첫번째_문자가_숫자인지_검증() {
        // given
        String nums = "1:2";
        // when & then
        assertTrue(NumUtil.startWithNum(nums));
    }

    @Test
    void nums_검증_예외_첫번째_문자가_숫자가_아닌_경우() {
        // given
        String invalidNums = ":2";
        // when & then
        assertFalse(NumUtil.startWithNum(invalidNums));
    }

    @Test
    void nums_검증_예외_빈_문자열인_경우() {
        // given
        String emptyNums = "";
        // when & then
        assertTrue(NumUtil.startWithNum(emptyNums)); // 통과
    }

    @Test
    void char_을_정수로_변환() {
        // given
        char c = '0';
        // when & then
        for (int i = 0; i < 10; i++) {
            assertEquals(i, NumUtil.toLong(String.valueOf((char) (c + i))));
        }
    }

    @Test
    void 정수_변환_예외_숫자가_아닌_경우1() {
        // given
        String invalidChar = "3.2";
        // when & then
        assertThrows(IllegalArgumentException.class, () -> NumUtil.toLong(invalidChar));
    }

    @Test
    void 정수_변환_예외_숫자가_아닌_경우2() {
        // given
        String invalidChar = " ";
        // when & then
        assertThrows(IllegalArgumentException.class, () -> NumUtil.toLong(invalidChar));
    }
}