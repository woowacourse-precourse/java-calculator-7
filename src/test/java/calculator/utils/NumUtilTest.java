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
            assertTrue(NumUtil.isPositiveNum(String.valueOf((char) (c + i))));
        }
    }

    @Test
    void 숫자_검증_예외_숫자가_아닌_경우_1() {
        // given
        String invalidChar = "1.";
        // when & then
        assertFalse(NumUtil.isPositiveNum(invalidChar));
    }

    @Test
    void 숫자_검증_예외_숫자가_아닌_경우_2() {
        // given
        String invalidChar = "3,2";
        // when & then
        assertFalse(NumUtil.isPositiveNum(invalidChar));
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
    void 문자열을_숫자로_변환() {
        // given
        char c = '0';
        // when & then
        for (int i = 0; i < 10; i++) {
            assertEquals(i, NumUtil.toLong(String.valueOf((char) (c + i))));
        }
    }

    @Test
    void 숫자_변환_예외_구분자가_포함된_경우() {
        // given
        String invalidNum = "3.2";
        // when & then
        assertThrows(IllegalArgumentException.class, () -> NumUtil.toLong(invalidNum));
    }

    @Test
    void 숫자_변환_예외_공백인_경우() {
        // given
        String invalidNum = " ";
        // when & then
        assertThrows(IllegalArgumentException.class, () -> NumUtil.toLong(invalidNum));
    }

    @Test
    void 정수_범위가_넘는_경우_확인() {
        // given
        long longValue = 2147483648L;
        // when & then
        long result = NumUtil.toLong(String.valueOf(longValue));
        assertEquals(longValue, result);
    }

    @Test
    void 숫자_변환_예외_음수인_경우() {
        // given
        long negative = -1L;
        // when & then
        assertThrows(IllegalArgumentException.class, () -> NumUtil.toLong(String.valueOf(negative)));
    }
}