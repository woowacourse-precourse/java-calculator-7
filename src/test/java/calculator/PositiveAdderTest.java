package calculator;

import static org.junit.jupiter.api.Assertions.*;

import calculator.domain.Number;
import calculator.domain.PositiveAdder;
import java.util.List;
import org.junit.jupiter.api.Test;

class PositiveAdderTest {

    @Test
    void 음수가_들어왔을_때_실패() {
        // given
        List<Number> sumTargets = List.of(Number.from("-1"), Number.from("2"),Number.from("3"));
        PositiveAdder positiveAdder = new PositiveAdder();

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            positiveAdder.calculateSum(sumTargets);
        });
    }
}