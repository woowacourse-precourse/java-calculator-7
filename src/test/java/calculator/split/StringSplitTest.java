package calculator.split;

import static calculator.split.StringSplit.getBackString;
import static calculator.split.StringSplit.getFrontString;
import static calculator.split.StringSplit.splitStringBySeparator;
import static calculator.split.StringSplit.stringToNumber;
import static calculator.validate.StringValidate.validateFrontString;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringSplitTest {
    @Test
    @DisplayName("문자열에서 '\n' 앞 부분을 올바르게 추출했는지 검증")
    void extractFrontString() {
        String string = "//abc\n123";

        assertEquals("abc", getFrontString(string));
    }

    @Test
    @DisplayName("문자열에서 '\n' 뒷 부분을 올바르게 추출했는지 검증")
    void extractBackString() {
        String string = "//abc\n123";

        assertEquals("123", getBackString(string));
    }

    @Test
    @DisplayName("첫번째로 나오는 '\n'로 문자열을 자른다.")
    void splitAtFirstNewline() {
        String string = "//abc\n\n123";

        assertEquals("abc", getFrontString(string));
        assertEquals("\n123", getBackString(string));
    }

    @Test
    @DisplayName("문자열에서 '\n' 뒷 부분이 빈 문자열인 경우")
    void backStringEmpty() {
        String string = "//abc\n";

        assertEquals("", getBackString(string));
    }

    @Test
    @DisplayName("앞 문자열이 문자로만 구성되어 있으면 true 반환")
    void onlyCharacterInFrontString() {
        String string = "abc";

        Assertions.assertTrue(validateFrontString(string));
    }

    @Test
    @DisplayName("앞 문자열에 숫자가 있으면 IllegalArgumentException 발생")
    void isNumberInFrontString() {
        String string = "1abc";

        assertThrows(IllegalArgumentException.class, () -> validateFrontString(string));
    }

    @Test
    @DisplayName("구분자로 계산해야 하는 문자열을 끊고, 배열을 반환한다.")
    void testSplitStringBySeparator() {
        String string = "12a34b5c";
        String separator = "abc";

        int[] expected = new int[]{12, 34, 5, 0};

        assertArrayEquals(expected, splitStringBySeparator(string, separator));
    }

    @Test
    @DisplayName("계산할 문자열이 빈 경우에는 길이가 1인 배열 [0]을 반환한다.")
    void emptyString() {
        String string = "";
        String separator = "a";

        int[] expected = new int[]{0};

        assertArrayEquals(expected, splitStringBySeparator(string, separator));
    }

    @Test
    @DisplayName("계산할 문자열이 구분자로만 이루어진 경우에는 0으로 채워진 배열을 반환한다.")
    void containWithOnlySeparator() {
        String string = "abcabc";
        String separator = "abc";
        int[] expected = new int[]{0, 0, 0, 0, 0, 0, 0};

        assertArrayEquals(expected, splitStringBySeparator(string, separator));
    }

    @Test
    @DisplayName("문자열을 숫자로 변환한다.")
    void testStringToNumber() {
        String string = "12";
        assertEquals(12, stringToNumber(string));
    }

    @Test
    @DisplayName("빈 문자열을 숫자 '0'으로 변환한다.")
    void emptyStringToZero() {
        String string = "";
        assertEquals(0, stringToNumber(string));
    }
}