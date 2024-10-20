package calculator.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class DelimitersTest {
    @Test
    void 기본_구분자는_쉼표와_콜론이다(){
        // given
        Delimiters delimiters = new Delimiters();

        // when
        List<String> defaultDelimiters = delimiters.getDelimiters();

        // then
        assertThat(defaultDelimiters).isEqualTo(Arrays.asList(",",":"));
    }

    @Test
    void 커스텀_구분자는_문자열_앞부분의_슬러시_두개와_개행문자_사이에_위치하는_문자이다(){
        // given
        Delimiters delimiters = new Delimiters();
        String input = "//;\\n1;2;3";

        // when
        String customDelimiter = delimiters.findCustomDelimiter(input) ;

        // then
        assertThat(customDelimiter).isEqualTo(";");
    }

    @Test
    void 구분자는_1글자여야_한다(){
        // given
        Delimiters delimiters = new Delimiters();
        String input = "//;;;;\\n1;2;3";

        assertThatThrownBy(() -> delimiters.findCustomDelimiter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자는 길이가 1인 문자여야 합니다.");
    }
}