package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberTest {
    @Test
    void 숫자를_더할_수_있다() {
        //given
        Number number = new Number(1);
        Number addNumber = new Number(1);

        //when
        number.addNumber(addNumber);

        //then
        assertThat(number.toString()).isEqualTo("2");
    }

}
