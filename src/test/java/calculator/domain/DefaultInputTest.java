package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class DefaultInputTest {

    @Test
    void 생성() {
        String text = "1";
        assertThat(DefaultInput.from(text)).isEqualTo(DefaultInput.from(text));
    }

    @Test
    void long_배열_생성() {
        Input defaultInput = DefaultInput.from("1");
        assertThat(defaultInput.createCalculationInputs()).containsExactly(1L);
    }

}
