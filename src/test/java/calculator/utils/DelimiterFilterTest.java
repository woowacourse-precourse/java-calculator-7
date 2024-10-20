package calculator.utils;

import static calculator.constant.DefaultSeparator.COLON;
import static calculator.constant.DefaultSeparator.COMMA;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DelimiterFilterTest {

    private DelimiterFilter delimiterFilter = new DelimiterFilter();

    @Test
    @DisplayName("hasCustomDelimiter - 커스텀 구분자가 정삭적으로 있을 때")
    void hasCustomDelimiterIsTrue() {
        // given
        String input = "//'\\n1'2'3'";
        // when
        boolean hasCustomDelimiter = delimiterFilter.hasCustomDelimiter(input);
        // then
        assertThat(hasCustomDelimiter).isTrue();
    }

    @Test
    @DisplayName("hasCustomDelimiter - 커스텀 구분자에 //는 있지만 \n 없을 때")
    void noSecondDelimiterStandard() {
        // given
        String input = "//'1'2'3'";
        // when
        boolean hasCustomDelimiter = delimiterFilter.hasCustomDelimiter(input);
        // then
        assertThat(hasCustomDelimiter).isFalse();
    }

    @Test
    @DisplayName("hasCustomDelimiter - 커스텀 구분자에 //는 없고 \n만 있을 때")
    void noFirstDelimiterStandard() {
        // given
        String input = "\\n'1'2'3'";
        // when
        boolean hasCustomDelimiter = delimiterFilter.hasCustomDelimiter(input);
        // then
        assertThat(hasCustomDelimiter).isFalse();
    }

    @Test
    @DisplayName("hasCustomDelimiter - 커스텀 구분자가 없을 때")
    void noDelimiterStandard() {
        // given
        String input = "'1'2'3'";
        // when
        boolean hasCustomDelimiter = delimiterFilter.hasCustomDelimiter(input);
        // then
        assertThat(hasCustomDelimiter).isFalse();
    }

    @Test
    @DisplayName("getDelimiter - 커스텀 구분자가 없을 때")
    void noCustomDelimiter() {
        // given
        String input = "1,2,3,4";
        // when
        List<Character> delimiter = delimiterFilter.getDelimiter(false, input);
        //then
        assertThat(delimiter).contains(COMMA.getSeparator(), COLON.getSeparator());
        assertThat(delimiter.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("getDelimiter - 커스텀 구분자가 하나 일 때")
    void hasCustomDelimiterOnlyOne() {
        //given
        String input = "//;\\n1;2;3";
        //when
        List<Character> delimiter = delimiterFilter.getDelimiter(true, input);
        //then
        assertThat(delimiter).contains(';');
        assertThat(delimiter.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("getDelimiter - 커스텀 구분자가 두 개 이상 일 때")
    void hasCustomDelimiterMoreTwo() {
        //given
        String input = "//;[]-\\n1;2;3";
        //when
        List<Character> delimiter = delimiterFilter.getDelimiter(true, input);
        //then
        assertThat(delimiter).contains(';', '[', ']', '-');
        assertThat(delimiter.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("getPureString - 커스텀 구분자가 있는 경우 해당 정보를 제외 후 순수 입력 값을 리턴한다.")
    void getPureString() {
        //given
        String input = "//;[\\n1,2,3";
        //when
        String pureString = delimiterFilter.getPureString(input);
        // then
        assertThat(pureString).isEqualTo("1,2,3");
    }
}