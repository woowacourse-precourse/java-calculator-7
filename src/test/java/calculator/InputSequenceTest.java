package calculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class InputSequenceTest {

    @Test
    void sum시_long범위_초과할시() {
        List<Long> sequence = List.of(Long.MAX_VALUE, 1L, 2L);
        InputSequence inputSequence = new InputSequence(sequence);
        assertThatThrownBy(inputSequence::sum)
                .hasMessage("더한 값이 너무 큽니다.");
    }
}