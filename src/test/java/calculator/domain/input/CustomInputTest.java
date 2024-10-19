package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.domain.input.CustomInput;
import org.junit.jupiter.api.Test;

public class CustomInputTest {

    private final String CUSTOM_TEXT = "//;\\n1;2;3";

    @Test
    void 생성() {
        assertThat(CustomInput.from(CUSTOM_TEXT)).isEqualTo(CustomInput.from(CUSTOM_TEXT));
    }

    @Test
    void long_배열_생성() {
        assertThat(CustomInput.from(CUSTOM_TEXT).createCalculationInputs())
                .containsExactly(1L, 2L, 3L);
    }
}
