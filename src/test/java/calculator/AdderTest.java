package calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class AdderTest {
    Adder adder = new Adder();

    @Test
    void 공백일때_0을_return_하는지() {
        adder.add(List.of(""));
        assertEquals(0, adder.getAnswer());
    }
}