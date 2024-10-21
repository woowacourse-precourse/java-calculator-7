package calculator.domain.input;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class OtherInputTest {

    private final String OTHER_TEXT = "123";

    @Test
    void 생성() {
        assertThat(OtherInput.from(OTHER_TEXT)).isEqualTo(OtherInput.from(OTHER_TEXT));
    }

    @Test
    void long_배열_생성() {
        assertThat(OtherInput.from(OTHER_TEXT).createCalculationInputs())
                .containsExactly(123L);
    }

}
