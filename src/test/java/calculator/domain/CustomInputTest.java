package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CustomInputTest {

    @Test
    void 생성() {
        String text = "//;\n1;2;3";
        assertThat(CustomInput.from(text)).isEqualTo(CustomInput.from(text));
    }

    @Test
    void long_배열_생성() {
        Input customInput = CustomInput.from("//;\\n1;2;3");
        assertThat(customInput.createCalculationInputs()).containsExactly(1L, 2L, 3L);
    }
}
