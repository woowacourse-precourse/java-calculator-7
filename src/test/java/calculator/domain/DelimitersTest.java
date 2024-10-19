package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DelimitersTest {

    @Test
    @DisplayName("Delimiters는_기본_구분자와_커스텀_구분자를_모두_고려하여_정규표현식을_반환한다")
    public void convertToRegex() {
        //given
        CustomDelimiter customDelimiter = new CustomDelimiter("t");

        //when
        String result = new Delimiters(customDelimiter).convertToRegex();

        //then
        assertThat(result).isEqualTo(":|,|t");
    }
}