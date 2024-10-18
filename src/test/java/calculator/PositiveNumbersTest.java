package calculator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PositiveNumbersTest {

    @Test
    void 숫자들의_합_계산(){
        PositiveNumbers positiveNumbers = PositiveNumbers.from(List.of(1, 2, 3));

        int sum = positiveNumbers.calculateSum();
        assertThat(sum).isEqualTo(6);
    }
}
