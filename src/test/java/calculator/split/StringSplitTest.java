package calculator.split;

import static calculator.split.StringSplit.getBackString;
import static calculator.split.StringSplit.getFrontString;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringSplitTest {
    @Test
    @DisplayName("문자열에서 '\n' 앞 부분을 올바르게 추출했는지 검증")
    void extractFrontString() {
        String string = "abc\n123";

        Assertions.assertEquals(getFrontString(string), "abc");
    }

    @Test
    @DisplayName("문자열에서 '\n' 뒷 부분을 올바르게 추출했는지 검증")
    void extractBackString() {
        String string = "abc\n123";

        Assertions.assertEquals(getBackString(string), "123");
    }

    @Test
    @DisplayName("첫번째로 나오는 '\n'로 문자열을 자른다.")
    void splitAtFirstNewline() {
        String string = "abc\n\n123";

        Assertions.assertEquals(getFrontString(string), "abc");
        Assertions.assertEquals(getBackString(string), "\n123");
    }

    @Test
    @DisplayName("문자열에서 '\n' 뒷 부분이 빈 문자열인 경우")
    void backStringEmpty() {
        String string = "abc\n";

        Assertions.assertEquals(getBackString(string), "");
    }
}