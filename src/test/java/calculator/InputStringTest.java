package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class InputStringTest {

    @Test
    void 빈_문자열() {
        // given
        var inputString = new InputString("");

        // when
        var result = inputString.getSum();

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    void NULL_문자열() {
        // given
        var inputString = new InputString(null);

        // when
        var result = inputString.getSum();

        // then
        assertThat(result).isEqualTo(0);
    }

}
