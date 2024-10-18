package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CustomDelimiterInputTest {

    @Test
    void 생성() {
        String text = "//;\n1;2;3";
        assertThat(CustomDelimiterInput.from(text)).isEqualTo(CustomDelimiterInput.from(text));
    }
}
