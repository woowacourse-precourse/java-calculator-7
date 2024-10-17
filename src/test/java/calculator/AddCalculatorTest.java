package calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AddCalculatorTest {

    @Test
    void 숫자가_한_개면_해당_숫자를_결과_값으로_반환한다() {
        double number = 1;
        double result = AddCalculator.add(number);

        assertEquals(1, result);
    }
}
