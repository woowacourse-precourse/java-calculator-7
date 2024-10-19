package calculator.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import util.Adder;

public class AdderTest {

    @Test
    void 넘겨받은_숫자배열_총합() {
        //given
        int[] numbers = {1, 2, 3, 4};
        //when
        int result = Adder.getSum(numbers);
        //then
        assertThat(result).isEqualTo(10);
    }
}
