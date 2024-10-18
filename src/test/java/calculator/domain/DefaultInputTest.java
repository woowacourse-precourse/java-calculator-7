package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class DefaultDelimiterInputTest {

    @Test
    void 생성() {
        String text = "1";
        assertThat(DefaultDelimiterInput.from(text)).isEqualTo(DefaultDelimiterInput.from(text));
    }
}
