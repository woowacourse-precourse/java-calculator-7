package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


class DelimiterTest {
    
    @DisplayName("기본 구분자(쉼표,클론)를 찾아 반환한다.")
    @Test
    void findDefaultDelimiters() {
        // given
        Delimiter delimiter = new Delimiter();
        String input = "1,2:3";

        // when
        String delimiters = delimiter.findDelimiter(input);

        // then
        assertThat(delimiters).isEqualTo(",|:");
    }

    @DisplayName("커스텀 구분자 (“//“와 “\\n” 사이)를 찾아 반환한다.")
    @Test
    void findCustomDelimiters() {
        // given
        Delimiter delimiter = new Delimiter();
        String input = "//;\\n1;2;3";

        // when
        String delimiters = delimiter.findDelimiter(input);

        // then
        assertThat(delimiters).isEqualTo(",|:|;");
    }

    @DisplayName("기본 구분자, 커스텀 구분자를 모두 반환한다.")
    @Test
    void findAllDelimiters() {
        // given
        Delimiter delimiter = new Delimiter();
        String input = "//;\\n1;2,3:4";

        // when
        String delimiters = delimiter.findDelimiter(input);

        // then
        assertThat(delimiters).isEqualTo(",|:|;");
    }

}