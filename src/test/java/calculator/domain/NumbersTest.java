package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NumbersTest {

    @Test
    void Number의_값들을_전부_더해서_반환한다() {
        //given
        String[] input = {"1", "2", "3"};
        Numbers numbers = new Numbers(input);

        //when
        int sum = numbers.add();

        //then
        Assertions.assertThat(sum).isEqualTo(6);
    }
}
