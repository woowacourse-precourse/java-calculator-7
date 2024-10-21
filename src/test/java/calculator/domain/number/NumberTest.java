package calculator.domain.number;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NumberTest {
    @Test
    void 숫자_등록() {
        //given
        String input = "16";
        Number number;

        //when
        number = new Number(input);

        //then
        assertThat(number.toInteger()).isEqualTo(Integer.parseInt(input));
    }
}