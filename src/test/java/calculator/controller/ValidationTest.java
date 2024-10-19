package calculator.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationTest {

    @Test
    @DisplayName("커스텀 구분자가 포함되지 않은 입력")
    void hasCustomDelimiter_withoutCustomDelimiter() {
        // given
        String testInput = "1,2;3";

        // when
        boolean actual = Validation.hasCustomDelimiter(testInput);

        // then
        assertThat(actual).isFalse();
    }

    @Test
    @DisplayName("커스텀 구분자가 포함된 입력")
    void hasCustomDelimiter_withCustomDelimiter() {
        // given
        String testInput = "//;\n1;2;3";

        // when
        boolean actual = Validation.hasCustomDelimiter(testInput);

        // then
        assertThat(actual).isTrue();
    }
}
