package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class AdderTest {
    Adder adder = new Adder();

    @Test
    void 공백일때_0을_return_하는지() {
        adder.add(List.of(""));
        assertEquals(0, adder.getAnswer());
    }

    @Test
    void 오버플로우_발생시_예외_처리() {
        assertThatThrownBy(() ->adder.add(List.of(String.valueOf(Double.MAX_VALUE),"1")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}