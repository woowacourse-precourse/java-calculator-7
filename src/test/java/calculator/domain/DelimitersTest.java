package calculator.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DelimitersTest {
    @Test
    void 기본_구분자는_쉼표와_콜론이다(){
        // given
        Delimiters delimiters = new Delimiters();

        // when
        List<Character> defaultDelimiters = delimiters.getDelimiters() ;

        // then
        assertThat(defaultDelimiters).isEqualTo(Arrays.asList(',',':'));
    }

}