package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberFormatterTest {

    private final NumberFormatter formatter = new NumberFormatter();

    @Test
    void formatTest() {
        // given
        final double sum = 5;
        // when
        final String formatted = formatter.format(sum);
        // then
        assertThat(formatted).matches("5");
    }

    @Test
    void 소수테스트() {
        // given
        final double sum = 2.99;
        // when
        final String formatted = formatter.format(sum);
        // then
        assertThat(formatted).matches("2.99");
    }

    @Test
    void 정수포맷테스트() {
        // given
        final double sum = 3.0;
        // when
        String formatted = formatter.format(sum);
        // then
        assertThat(formatted).matches("3");
    }
}
