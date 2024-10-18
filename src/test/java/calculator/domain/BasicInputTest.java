package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class BasicInputTest {

    @Test
    void 생성() {
        String text1 = "1,2,3";
        String text2 = "1:2:3";

        assertThat(BasicInput.from(text1)).isEqualTo(BasicInput.from(text1));
        assertThat(BasicInput.from(text2)).isEqualTo(BasicInput.from(text2));
    }

    @Test
    void long_배열_생성() {
        Input basicInput1 = BasicInput.from("1,2,3");
        Input basicInput2 = BasicInput.from("1:2:3");

        assertThat(basicInput1.createCalculationInputs()).containsExactly(1L, 2L, 3L);
        assertThat(basicInput2.createCalculationInputs()).containsExactly(1L, 2L, 3L);
    }
}
