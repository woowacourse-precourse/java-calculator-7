package calculator.split;

import static calculator.split.StringSplit.getBackString;
import static calculator.split.StringSplit.getFrontString;
import static calculator.validate.StringValidate.validateFrontString;
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
}