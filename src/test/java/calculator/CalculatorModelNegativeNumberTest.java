package calculator;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorModelNegativeNumberTest {

    private final CalculatorModel model = new CalculatorModel();

    @Test
    void testNegativeNumber() {
        Set<Character> delimiters = Set.of(',', ':');
        String input = "1,-2,3";

        assertThatThrownBy(() -> model.add(input, delimiters))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Negative numbers are not allowed");
    }
}
