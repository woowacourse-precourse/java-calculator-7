package calculator.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {

    @Test
    void TDD_빈_문자열_검증_아닐때() {
        //given
        String input = "1,2,3";

        //when
        boolean hasText = StringUtils.hasText(input);

        //then
        assertThat(hasText).isTrue();
    }

    @Test
    void TDD_빈_문자열_검증() {
        //given
        String input = "";

        //when
        boolean hasText = StringUtils.hasText(input);

        //then
        assertThat(hasText).isFalse();
    }
}
