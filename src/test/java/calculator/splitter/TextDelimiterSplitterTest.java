package calculator.splitter;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class TextDelimiterSplitterTest {

    @Test
    void TDD_텍스트_기본_구분자_분리() {
        //given
        String text = "1,2,3";
        Set<String> delimiters = Set.of(",", ":");

        //when
        TextDelimiterSplitter textDelimiterSplitter = new TextDelimiterSplitter();
        List<String> list = textDelimiterSplitter.split(text, delimiters);

        //then
        assertThat(list).containsExactly("1", "2", "3");
    }

    @Test
    void TDD_텍스트_커스텀_구분자_분리() {
        //given
        String text = "1,2|3";
        Set<String> delimiters = Set.of(",", ":", "|");

        //when
        TextDelimiterSplitter textDelimiterSplitter = new TextDelimiterSplitter();
        List<String> list = textDelimiterSplitter.split(text, delimiters);

        //then
        assertThat(list).containsExactly("1", "2", "3");
    }
}
