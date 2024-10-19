package calculator.splitter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static calculator.delimiter.BasicDelimiter.getBasicDelimiters;
import static calculator.delimiter.CustomDelimiter.getCustomDelimiters;
import static org.assertj.core.api.Assertions.assertThat;

public class TextDelimiterSplitterTest {

    TextDelimiterSplitter textDelimiterSplitter;

    @BeforeEach
    void before() {
        textDelimiterSplitter = new TextDelimiterSplitter();
    }

    @Test
    void TDD_텍스트_기본_구분자_분리() {
        //given
        String text = "1,2,3";

        //when
        List<String> list = textDelimiterSplitter.split(text, getBasicDelimiters());

        //then
        assertThat(list).containsExactly("1", "2", "3");
    }

    @Test
    void TDD_텍스트_커스텀_구분자_분리() {
        //given
        String text = "1,2|3";

        //when
        List<String> list = textDelimiterSplitter.split(text, getCustomDelimiters("|"));

        //then
        assertThat(list).containsExactly("1", "2", "3");
    }

    @Test
    void 텍스트_기본_구분자_분리_포맷_불일치_무시() {
        //given
        String text = "1,,2:3,a";

        //when
        List<String> list = textDelimiterSplitter.split(text, getBasicDelimiters());

        //then
        assertThat(list).containsExactly("1", "", "2", "3", "a");
    }

    @Test
    void 커스텀_기본_구분자_분리_포맷_불일치_무시() {
        //given
        String text = "1,,2:3,a;db;ㅇㄹ";

        //when
        List<String> list = textDelimiterSplitter.split(text, getCustomDelimiters(";"));

        //then
        assertThat(list).containsExactly("1", "", "2", "3", "a", "db", "ㅇㄹ");
    }
}
