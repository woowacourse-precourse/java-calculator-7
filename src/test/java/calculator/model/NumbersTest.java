package calculator.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class NumbersTest {

    @Test
    void 숫자_저장_테스트() {
        Numbers numbers = new Numbers();
        numbers.saveNumber(4);
        numbers.saveNumber(2);
        assertThat(numbers.getNumbers())
                .isEqualTo(Arrays.asList(new Long[]{4L, 2L}));
    }
}
