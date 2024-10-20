package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberFormatterTest {

    @Test
    void formatTest() {
        // given
        final NumberFormatter formatter = new NumberFormatter();
        final double sum = 5;
        // when
        final String formatted = formatter.format(sum);
        // then
        assertThat(formatted).matches("5");
    }
}
