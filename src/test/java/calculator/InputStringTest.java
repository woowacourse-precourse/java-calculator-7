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

    @Test
    void 숫자_하나() {
        // given
        var inputString = new InputString("1");

        // when
        var result = inputString.getSum();

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 쉼표_구분자() {
        // given
        var inputString = new InputString("1,2,3");

        // when
        var result = inputString.getSum();

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 콜론_구분자() {
        // given
        var inputString = new InputString("1:2:3");

        // when
        var result = inputString.getSum();

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 쉼표_콜론_구분자() {
        // given
        var inputString = new InputString("1,2:3");

        // when
        var result = inputString.getSum();

        // then
        assertThat(result).isEqualTo(6);
    }

}
