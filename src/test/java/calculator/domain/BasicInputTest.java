package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class BasicDelimiterInputTest {

    @Test
    void 생성() {
        String text = "1,2,3";
        assertThat(BasicDelimiterInput.from(text)).isEqualTo(BasicDelimiterInput.from(text));
    }
}
