package calculator.domain.input;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CustomInputTest {

    private final String CUSTOM_TEXT = "//;\\n1;2;3";

    @Test
    void 생성() {
        assertThat(CustomDelimiterInput.from(CUSTOM_TEXT)).isEqualTo(CustomDelimiterInput.from(CUSTOM_TEXT));
    }

    @Test
    void long_배열_생성() {
        assertThat(CustomDelimiterInput.from(CUSTOM_TEXT).createCalculationInputs())
                .containsExactly(1L, 2L, 3L);
    }
}