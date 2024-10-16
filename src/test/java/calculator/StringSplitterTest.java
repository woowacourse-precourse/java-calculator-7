package calculator;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringSplitterTest {

    @DisplayName("기본 구분자 포함 문자열 분리")
    @Test
    void splitTest() {
        // given
        StringSplitter splitter = new StringSplitter();
        String str = "1,2:3";

        // when
        List<String> list = splitter.split(str);

        // then
        assert list.size() == 3;
        assert list.get(0).equals("1");
        assert list.get(1).equals("2");
        assert list.get(2).equals("3");
    }

    @DisplayName("커스텀 구분자 포함 문자열 분리")
    @Test
    void splitTest_CustomDelimiters() {
        // given
        StringSplitter splitter = new StringSplitter();
        String str = "//;\n1;2;3";

        // when
        List<String> list = splitter.split(str);

        // then
        assert list.size() == 3;
        assert list.get(0).equals("1");
        assert list.get(1).equals("2");
        assert list.get(2).equals("3");
    }

}