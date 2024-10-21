package calculator.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SumCalculatorTest {
    private SumCalculator sumCalculator;

    @BeforeEach
    void setup() {
        sumCalculator = new SumCalculator();
    }

    @Test
    void sum_isEmpty() {
        String input = "";

        int result = sumCalculator.sum(input);

        assertThat(result).isEqualTo(0);
    }

}