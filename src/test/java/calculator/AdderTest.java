package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AdderTest {

    @Test
    void 입력받은_문자열의_숫자를_더한다() {
        //given
        Adder adder = new Adder();
        String[] input = {"1", "2", "3"};

        //when
        int sum = adder.add(input);

        //then
        Assertions.assertThat(sum).isEqualTo(6);
    }
}
