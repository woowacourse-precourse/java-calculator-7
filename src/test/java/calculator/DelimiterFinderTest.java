package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


class DelimiterFinderTest {
    
    @DisplayName("기본 구분자(쉼표,클론)를 찾아 반환한다.")
    @Test
    void findDefaultDelimiters() {
        // given
        DelimiterFinder delimiterFinder = new DelimiterFinder();
        String input = "1,2:3";

        // when
        String delimiters = delimiterFinder.findDelimiter(input);

        // then
        assertThat(delimiters).isEqualTo(",|:");
    }

    @DisplayName("커스텀 구분자 (“//“와 “\\n” 사이)를 찾아 반환한다.")
    @Test
    void findCustomDelimiters() {
        // given
        DelimiterFinder delimiterFinder = new DelimiterFinder();
        String input = "//;\\n1;2;3";

        // when
        String delimiters = delimiterFinder.findDelimiter(input);

        // then
        assertThat(delimiters).isEqualTo(",|:|\\Q;\\E");
    }

    @DisplayName("기본 구분자, 커스텀 구분자를 모두 반환한다.")
    @Test
    void findAllDelimiters() {
        // given
        DelimiterFinder delimiterFinder = new DelimiterFinder();
        String input = "//;\\n1;2,3:4";

        // when
        String delimiters = delimiterFinder.findDelimiter(input);

        // then
        assertThat(delimiters).isEqualTo(",|:|\\Q;\\E");
    }

    @DisplayName("빈 입력에 대해 기본 구분자를 반환한다.")
    @Test
    void findDelimiters_emptyInput() {
        // given
        DelimiterFinder delimiterFinder = new DelimiterFinder();
        String input = "";

        // when
        String delimiters = delimiterFinder.findDelimiter(input);

        // then
        assertThat(delimiters).isEqualTo(",|:");
    }

    @DisplayName("커스텀 구분자가 비어있는 경우 기본 구분자만 반환한다.")
    @Test
    void findDelimiters_emptyCustomDelimiter() {
        // given
        DelimiterFinder delimiterFinder = new DelimiterFinder();
        String input = "//\\n1,2,3";

        // when
        String delimiters = delimiterFinder.findDelimiter(input);

        // then
        assertThat(delimiters).isEqualTo(",|:");
    }

    @DisplayName("커스텀 구분자가 이스케이프 문자여도 정상적으로 반환된다.")
    @Test
    void findDelimiters_escape() {
        // given
        DelimiterFinder delimiterFinder = new DelimiterFinder();
        String input = "//\\\\n1,2,3";
        // when
        String delimiters = delimiterFinder.findDelimiter(input);

        // then
        // \Q와 \E로 둘러싼 부분에 있는 특수문자를 이스케이프
        assertThat(delimiters).isEqualTo(",|:|\\Q\\\\E" );
    }

}