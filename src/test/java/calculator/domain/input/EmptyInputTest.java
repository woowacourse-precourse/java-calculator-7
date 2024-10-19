package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.domain.input.EmptyInput;
import org.junit.jupiter.api.Test;

public class EmptyInputTest {

    private final String EMPTY_TEXT = "";

    @Test
    void 생성() {
        assertThat(EmptyInput.from(null)).isEqualTo(EmptyInput.from(null));
        assertThat(EmptyInput.from(EMPTY_TEXT)).isEqualTo(EmptyInput.from(EMPTY_TEXT));
    }

    @Test
    void long_배열_생성() {
        assertThat(EmptyInput.from(null).createCalculationInputs())
                .containsExactly(0L);

        assertThat(EmptyInput.from(EMPTY_TEXT).createCalculationInputs())
                .containsExactly(0L);

    }

}
