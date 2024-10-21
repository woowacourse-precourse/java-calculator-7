package calculator.addition;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class IntegerAdditionCalculatorTest {


    @Test
    public void 정수_리스트의_모든_요소_더하기() throws Exception {
        //given
        List<Integer> integers = Arrays.asList(1, 2, 3);

        //when
        int result = IntegerAdditionCalculator.calculation(integers);

        //then
        assertThat(result).isEqualTo(6);
    }

}