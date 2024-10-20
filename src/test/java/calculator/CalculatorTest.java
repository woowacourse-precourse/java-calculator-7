package calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    @Test
    void Integer보다_큰_값을_계산할_수_없다() {
        assertThrows(ArithmeticException.class, () -> {
            int i = Integer.MAX_VALUE / 3;

            Calculator.sum(List.of(i, i, i, i));
        });
    }
}