package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class DelimiterTest {

    @Test
    void 커스텀구분자의_구분문자만_입력한_경우() {
        //given
        String input = "//\\n4";
        Delimiter delimiter = new Delimiter(input);

        //when
        String[] strings = delimiter.extractDelimiterAndNumber();

        //then
        assertThat(strings).containsExactly("4");
    }

    @Test
    void 커스텀구분자를_1개_입력한_경우() {
        //given
        String input = "//;\\n4;3";
        Delimiter delimiter = new Delimiter(input);

        //when
        String[] strings = delimiter.extractDelimiterAndNumber();

        //then
        assertThat(strings).containsExactly("4", "3");
    }

    @Test
    void 커스텀구분자를_2개_입력한_경우() {
        //given
        String input = "//;^\\n4;3";
        Delimiter delimiter = new Delimiter(input);

        //when & then
        assertThatThrownBy(delimiter::extractDelimiterAndNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("커스텀 구분자는 하나의 문자만 지정할 수 있습니다.");
    }

    @Test
    void 커스텀구분자는_존재하지만_숫자가_입력되지_않은_경우() {
        //given
        String input = "//;\\n";
        Delimiter delimiter = new Delimiter(input);

        //when
        String[] strings = delimiter.extractDelimiterAndNumber();

        //then
        assertThat(strings).containsExactly("");
    }

    @Test
    void 커스텀구분자를_구분하는_구분문자가_완전하지_않은_경우() {
        //given
        String input = "//;3;2";
        Delimiter delimiter = new Delimiter(input);

        //when
        String string = delimiter.getDelimiter();

        //then
        assertThat(string).isEqualTo(",|:");
    }

    @Test
    void 기본구문자와_숫자만_존재하는_경우() {
        //given
        String input = "1:2,0";
        Delimiter delimiter = new Delimiter(input);

        //when
        String[] strings = delimiter.extractDelimiterAndNumber();

        //then
        assertThat(strings).containsExactly("1", "2", "0");
    }

    @Test
    void 기본구문자만_존재하는_경우() {
        //given
        String input = ":,";
        Delimiter delimiter = new Delimiter(input);

        //when
        String[] strings = delimiter.extractDelimiterAndNumber();

        //then
        assertThat(strings).isEmpty();
    }

    @Test
    void 구분자가_존재하지_않는_경우() {
        //given
        String input = "345";
        Delimiter delimiter = new Delimiter(input);

        //when
        String[] strings = delimiter.extractDelimiterAndNumber();

        //then
        assertThat(strings).containsExactly("345");
    }

    @Test
    void 기본구문자와_커스텀구분자가_모두_존재하는_경우() {
        //given
        String input = "//&\\n1:2,0&3";
        Delimiter delimiter = new Delimiter(input);

        //when
        String[] strings = delimiter.extractDelimiterAndNumber();

        //then
        assertThat(strings).containsExactly("1", "2", "0", "3");
    }

    @Test
    void 기본구문자와_커스텀구분자가_모두_존재하지만_기본구분자만_사용된_경우() {
        //given
        String input = "//&\\n1:2,0:3";
        Delimiter delimiter = new Delimiter(input);

        //when
        String[] strings = delimiter.extractDelimiterAndNumber();

        //then
        assertThat(strings).containsExactly("1", "2", "0", "3");
    }
}