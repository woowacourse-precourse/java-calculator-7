package calculator.domain.input.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputValidateUtilsTest {

    @Test
    void TDD_빈_문자열_검증_아닐때() {
        //given
        String input = "1,2,3";

        //when
        boolean hasText = InputValidateUtils.hasText(input);

        //then
        assertThat(hasText).isTrue();
    }

    @Test
    void TDD_빈_문자열_검증() {
        //given
        String input = "";

        //when
        boolean hasText = InputValidateUtils.hasText(input);

        //then
        assertThat(hasText).isFalse();
    }
}
